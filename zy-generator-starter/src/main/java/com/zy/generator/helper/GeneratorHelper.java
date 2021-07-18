package com.zy.generator.helper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * fileName: GeneratorHelper
 * create: 2021-7-18 12:57
 * description:
 * history:
 *
 * @author 张建元 18143774515@163.com
 */
@Component
public class GeneratorHelper {
    /**
     * 时间格式化
     */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
    /**
     * 当前操作系统
     */
    @SuppressWarnings("unused")
    private static final boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().contains("windows");
    /**
     * 驱动连接的URL
     */
    @Value("${spring.datasource.url}")
    private String url;
    /**
     * 数据库连接用户名
     */
    @Value("${spring.datasource.username}")
    private String username;
    /**
     * 数据库连接密码
     */
    @Value("${spring.datasource.password}")
    private String password;
    
    public static void main(String[] args) {
        new GeneratorHelper().creatCode();
    }
    
    public void creatCode() {
        url = "jdbc:mysql://mysql80.server.com:23306/db_generator?useUnicode=true&characterEncoding=UTF-8" +
                "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        username = "root";
        password = "123456";
        autoGenerator("db_generator");
    }
    
    private void autoGenerator(String schemaName) {
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig(url, username, password, schemaName));
        autoGenerator.global(globalConfig("D:/generator/code", "张建元 18143774515@163.com"));
        autoGenerator.packageInfo(packageConfig("com.zy.generator", ""));
        autoGenerator.template(new TemplateConfig.Builder().build());
        autoGenerator.strategy(strategyConfig());
        autoGenerator.execute();
    }
    
    /**
     * 全局配置
     *
     * @param outputDir 生成代码位置
     * @param author    作者
     * @return 全局配置
     */
    private GlobalConfig globalConfig(String outputDir, String author) {
        GlobalConfig.Builder builder = new GlobalConfig.Builder();
        return builder
                // 覆盖已有文件
                .fileOverride()
                // 打开输出目录
                .openDir(true)
                // 输出目录
                .outputDir(outputDir)
                // 开发人员
                .author(author)
                // 开启 swagger 模式 enableSwagger()
                // 时间类型对应策略: 使用 java.time 包下的 java8 新的时间类型
                .dateType(DateType.TIME_PACK)
                // 获取注释日期: yyyy-MM-dd hh:mm:ss
                .commentDate(() -> LocalDateTime.now().format(FORMATTER))
                .build();
    }
    
    /**
     * 数据源配置
     *
     * @param url        驱动连接的URL
     * @param username   数据库连接用户名
     * @param password   数据库连接密码
     * @param schemaName schemaName
     * @return 数据源配置
     */
    private DataSourceConfig dataSourceConfig(String url, String username, String password, String schemaName) {
        DataSourceConfig.Builder builder = new DataSourceConfig.Builder(url, username, password);
        return builder.schema(schemaName).build();
    }
    
    /**
     * 包配置
     *
     * @param parent     父包名
     * @param moduleName 模块名称
     * @return 包配置
     */
    private PackageConfig packageConfig(String parent, String moduleName) {
        PackageConfig.Builder builder = new PackageConfig.Builder();
        parent = parent == null ? "com.zy.generator" : parent;
        return builder
                // 指定父包名
                .parent(parent)
                // 指定模块名称
                .parent(moduleName)
                // 指定实体包名
                .entity(parent.concat(".domain.entity"))
                // 指定service接口包名
                .service(parent.concat(".app.service"))
                // service实现类包名
                .serviceImpl(parent.concat(".app.service.impl"))
                // 指定mapper接口包名
                .mapper(parent.concat(".infra.mapper"))
                // 指定xml包名
                .xml("mapper")
                // 指定控制器包名
                .controller(parent.concat(".api.controller"))
                // 路径配置信息
                .pathInfo(new HashMap<>())
                // 连接父子包名 joinPackage()
                .build();
    }
    
    private StrategyConfig strategyConfig() {
        StrategyConfig.Builder builder = new StrategyConfig.Builder();
        StrategyConfig strategyConfig = builder
                // 开启大写命名
                .enableCapitalMode()
                // 开启跳过视图
                .enableSkipView()
                .build();
        // 实体配置构建者
        strategyConfig.entityBuilder()
                // 开启生成字段常量
                .enableColumnConstant()
                // 开启lombok模型
                .enableLombok()
                // 开启Boolean类型字段移除is前缀
                .enableRemoveIsPrefix()
                // 开启生成实体时生成字段注解
                .enableTableFieldAnnotation()
                // 设置乐观锁数据库表字段名称
                .versionColumnName("version")
                // 设置乐观锁实体属性字段名称
                .versionPropertyName("version")
                // 逻辑删除数据库字段名称
                .logicDeleteColumnName("delete_flag")
                // 逻辑删除实体属性名称
                .logicDeletePropertyName("deleteFlag")
                // 数据库表映射到实体的命名策略
                .naming(NamingStrategy.underline_to_camel)
                // 数据库表字段映射到实体的命名策略
                .columnNaming(NamingStrategy.underline_to_camel)
                // 指定生成的主键的ID类型
                .idType(IdType.ASSIGN_ID)
                .build();
        // 控制器配置构建者
        strategyConfig.controllerBuilder()
                // 开启驼峰转连字符
                .enableHyphenStyle()
                // 开启生成@RestController控制器
                .enableRestStyle()
                .build();
        // Mapper配置构建者
        strategyConfig.mapperBuilder()
                .build();
        // Service配置构建者
        strategyConfig.serviceBuilder()
                .formatServiceFileName("%sService")
                .build();
        return strategyConfig;
    }
}
