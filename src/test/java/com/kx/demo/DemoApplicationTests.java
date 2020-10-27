package com.kx.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;


@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String propertyPath = System.getProperty("user.dir");
        gc.setAuthor("kx")//作者
                .setFileOverride(false)// 是否覆盖已有文件
                .setOutputDir(propertyPath + "/src/main/java")//java文件输出位置
//                .setEnableCache(true)//是否开启二级缓存
                .setActiveRecord(true)//活动记录
                .setBaseResultMap(true)//通用查询映射结果
                .setBaseColumnList(true)//通用查询结果列
//                .setDateType()//配置时间类型
                .setIdType(AUTO)//设置主键类型
                .setOpen(true);//完成后 打开访达


        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/mp-test")//地址
                .setDriverName("com.mysql.cj.jdbc.Driver")//数据驱动
                .setUsername("root")//账户
                .setPassword("192354...")//密码
                .setDbType(DbType.MYSQL);//数据库类型

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.kx.demo.tt")//父包名
//                .setController("")//配置controller 包名称
//                .setService("")//配置service 服务包名称
//                .setServiceImpl("")//配置serviceImpl 服务实现包名称
                .setEntity("pojo")//配置实体类包名称
                .setMapper("dao");//配置dao包名


        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 数据库表配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略 下划线转驼峰命名
                .setColumnNaming(NamingStrategy.underline_to_camel)// 数据库表字段映射到实体的命名策略
                .setEntityLombokModel(true)
//                .setSuperEntityClass("com.kx.demo.pojo")//实体类继承 的类
//                .setSuperEntityColumns()//自定义公共字段
//                .setSuperControllerClass("com.kx.demo.controller")//controller继承类
//                .setSuperServiceClass("")//service继承类
//                .setSuperServiceImplClass("")//实现类 继承类


//                .setInclude("[a-z_]*")//包含的表
//                .setExclude("")//排除的表
                .setEntityColumnConstant(false)//是否生成常量字段
                .setChainModel(true)//是否为构建者模型
                .setControllerMappingHyphenStyle(true)
                .setRestControllerStyle(true)//生成 restController
//                .setFieldPrefix("")//字段前缀
                .setTablePrefix("tb_");//表前缀

        //模版引擎
        FreemarkerTemplateEngine fmt = new FreemarkerTemplateEngine();


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return propertyPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });


        cfg.setFileOutConfigList(focList);

        mpg.setCfg(cfg)
                .setGlobalConfig(gc)
                .setPackageInfo(pc)
                .setDataSource(dsc)
                .setStrategy(strategy)
                // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
                .setTemplateEngine(fmt)
                .execute();

    }

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

}
