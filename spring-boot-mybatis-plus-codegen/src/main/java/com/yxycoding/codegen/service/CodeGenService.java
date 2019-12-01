package com.yxycoding.codegen.service;

import com.yxycoding.codegen.entity.GenConfig;

public interface CodeGenService {

    /**
     * 生成代码
     *
     * @param genConfig 生成配置
     * @return 代码压缩文件
     */
    byte[] generatorCode(GenConfig genConfig);


}
