package com.zy.server.core.infra.repository.impl;

import com.zy.server.core.domain.entity.email.Sender;
import com.zy.server.core.domain.repository.SenderRepository;
import org.springframework.stereotype.Repository;

/**
 * fileName: SenderRepositoryImpl
 * create: 2021-5-29 21:44
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Repository
public class SenderRepositoryImpl implements SenderRepository {
    /**
     * 通过发件人获取发件人信息
     *
     * @param from 发件人
     * @return 发件人信息
     */
    @Override
    public Sender getSenderByFrom(String from) {
        return null;
    }
}
