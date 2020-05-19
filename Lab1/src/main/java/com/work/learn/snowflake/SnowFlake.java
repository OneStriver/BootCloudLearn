package com.work.learn.snowflake;

/**
 * @description: 生成不重复ID
 * @author: HeYin
 * @date: 2020-05-19 16:26
 * @version: 1.0
 */
public class SnowFlake {

    // 为了满足每秒产生上万条不重复id并且保证一定的顺序的产生
    // 1 41位 时间戳 10位机器id 12位序列号
    //开始生成的时间戳，用当前时间戳-twepoch作为雪花算法的时间戳
    private final long twepoch = 1539658610050L;
    //服务器id占的位数
    private final long serverIdBits = 10L;
    //服务器id最大值
    private final long maxServerId = 1 << serverIdBits -1;
    //序列号占的位数
    private final long sequenceBits = 12L;
    //服务器id右移位数
    private final long serverIdShift = sequenceBits;
    //时间戳id右移位数
    private final long timestampLeftShift = sequenceBits + serverIdBits;
    //最大序列化
    private final long maxSequence = 1<< sequenceBits-1;

    private long serverId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public synchronized Long generatorKey() {
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("时间被调整,上次时间戳 %d>%d", lastTimestamp,timestamp));
        }
        if (lastTimestamp == timestamp) {
            sequence=(sequence+1) % maxSequence;
            if (sequence==0) {
                //如果这毫秒的序列号用完，自旋等待下以毫秒再生成
                while ((timestamp=System.currentTimeMillis())<=lastTimestamp){}
            }
        } else {
            sequence=0L;
        }
        lastTimestamp = timestamp;
        return ((timestamp - twepoch) << timestampLeftShift)  | (serverId << serverIdShift) |sequence;
    }


}
