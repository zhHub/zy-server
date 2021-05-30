package com.zy.server.core.domain.repository;

import com.zy.server.core.domain.entity.email.Sender;

/**
 * fileName: SenderRepository
 * create: 2021-5-29 21:44
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
public interface SenderRepository {
    /**
     * 通过发件人获取发件人信息
     *
     * @param from 发件人
     * @return 发件人信息
     */
    Sender getSenderByFrom(String from);
}
