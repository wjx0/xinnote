package com.xin.note.common.utils;

import com.xiaoleilu.hutool.io.FileUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import org.apache.commons.lang.ObjectUtils;
import org.apache.velocity.VelocityContext;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.rmic.iiop.Generator;

import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 代码生成类
 * Created by xin
 */
public class MybatisGeneratorUtil {

	// Service模板路径
	private  static String serviceVm = "/generatortemplates/Service.vm";
	// ServiceImpl模板路径
	private  static String serviceImplVm = "/generatortemplates/ServiceImpl.vm";
    // Controller模板路径
    private  static String controllerVm = "/generatortemplates/Controller.vm";
	// mybatis generator模板路径
	private  static String generatorConfigVm = "/generatortemplates/generatorConfig.vm";
	// mybatis generator模板路径
	private  static String serviceTestVm = "/generatortemplates/ServiceTest.vm";

	private static Logger logger = LoggerFactory.getLogger(MybatisGeneratorUtil.class);

	/**
	 * 根据模板生成generatorConfig.xml文件
	 * @param jdbcDriver   驱动路径
	 * @param jdbcUrl      链接
	 * @param jdbcUsername 帐号
	 * @param jdbc_password 密码
	 * @param tablePrefix  表前缀
	 * @param package_name  包名
	 */
	public static void generate(
			String jdbcDriver,
			String jdbcUrl,
			String jdbcUsername,
			String jdbc_password,
			String tablePrefix,
			String package_name,
			String rootClass) throws Exception{

		serviceVm = URLDecoder.decode(MybatisGeneratorUtil.class.getResource(serviceVm).getPath().replaceFirst("/", ""),"utf-8");;
		serviceImplVm = URLDecoder.decode(MybatisGeneratorUtil.class.getResource(serviceImplVm).getPath().replaceFirst("/", ""),"utf-8");;
        controllerVm = URLDecoder.decode(MybatisGeneratorUtil.class.getResource(controllerVm).getPath().replaceFirst("/", ""),"utf-8");;
		generatorConfigVm = URLDecoder.decode(MybatisGeneratorUtil.class.getResource(generatorConfigVm).getPath().replaceFirst("/", ""),"utf-8");;
		serviceTestVm = URLDecoder.decode(MybatisGeneratorUtil.class.getResource(serviceTestVm).getPath().replaceFirst("/", ""),"utf-8");;

		String basePath = URLDecoder.decode(MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/classes/", "").replaceFirst("/", ""),"utf-8");
		String generatorConfigXml =URLDecoder.decode( MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/classes/", "") ,"utf-8")+"/src/main/resources/generatorConfig.xml";
		String sql = "select * from user_tables where  table_name LIKE '%" + tablePrefix + "%' and table_name not like '%_LANG'";

		logger.info("========== 开始生成generatorConfig.xml文件 ==========");
		List<Map<String, Object>> tables = new ArrayList<>();
		try {
			VelocityContext context = new VelocityContext();
			Map<String, Object> table;

			// 查询定制前缀项目的所有表
			JdbcUtil jdbcUtil = new JdbcUtil(jdbcDriver, jdbcUrl, jdbcUsername, jdbc_password);
			List<Map> result = jdbcUtil.selectByParams(sql, null);
			for (Map map : result) {
				table = new HashMap<>();
				table.put("table_name", map.get("TABLE_NAME"));
				table.put("model_name", StrUtil.upperFirst(StrUtil.toCamelCase(ObjectUtils.toString(map.get("TABLE_NAME")))));
				tables.add(table);
			}
			jdbcUtil.release();

			context.put("tables", tables);
			context.put("rootClass", rootClass);
			context.put("generator_javaModelGenerator_targetPackage", package_name + ".entity");
			context.put("generator_sqlMapGenerator_targetPackage", "mappers");
			context.put("generator_javaClientGenerator_targetPackage", package_name + ".dao");
			VelocityUtil.generate(generatorConfigVm, generatorConfigXml, context);

			String moduleDir = URLDecoder.decode(Generator.class.getResource("/").getPath().replace("/target/classes/", "").
					replaceFirst("/", ""), "utf-8")+"/src/main/java/"
					+package_name.replaceAll("\\.", "/") ;
			//建好模块下边相应的文件夹
			if(!FileUtil.exist(moduleDir+ "/dao")) {
				FileUtil.mkdir(moduleDir+ "/dao");
			}
			if(!FileUtil.exist(moduleDir+ "/entity")) {
				FileUtil.mkdir(moduleDir+ "/entity");
			}
			if(!FileUtil.exist(moduleDir+ "/enums")) {
				FileUtil.mkdir(moduleDir+ "/enums");
			}
			if(!FileUtil.exist(moduleDir+ "/controller")) {
				FileUtil.mkdir(moduleDir+ "/controller");
			}
			if(!FileUtil.exist(moduleDir+ "/service")) {
				FileUtil.mkdir(moduleDir+ "/service");
			}
			if(!FileUtil.exist(moduleDir+ "/service/impl")) {
				FileUtil.mkdir(moduleDir+ "/service/impl");
			}
			if(!FileUtil.exist(moduleDir.replace("src/main/java","src/test/java")+ "/service/impl")) {
				FileUtil.mkdir(moduleDir.replace("src/main/java","src/test/java")+ "/service/impl");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("========== 结束生成generatorConfig.xml文件 ==========");

		logger.info("========== 开始运行MybatisGenerator (生成Bean DAO xml文件) ==========");
		List<String> warnings = new ArrayList<>();
		File configFile = new File(generatorConfigXml);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		for (String warning : warnings) {
			logger.info(warning);
		}
		logger.info("========== 结束运行MybatisGenerator ==========");

		logger.info("========== 开始生成Service ServiceImpl Controller ServiceTest==========");
		String ctime = new SimpleDateFormat("yyyy/M/d").format(new Date());
		String servicePath = basePath  + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/service";
		String serviceImplPath = servicePath + "/impl";
        String controllerPath = basePath  + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/controller";
		String serviceTestPath = basePath  + "/src/test/java/" + package_name.replaceAll("\\.", "/") + "/service/impl";
		for (int i = 0; i < tables.size(); i++) {
			String model = StrUtil.upperFirst(StrUtil.toCamelCase((ObjectUtils.toString(tables.get(i).get("table_name")))));
			String modelLowerFirst = StrUtil.lowerFirst(model);
			String service = servicePath + "/" + model + "Service.java";
			String serviceImpl = serviceImplPath + "/" + model + "ServiceImpl.java";
			String controller = controllerPath + "/" + model + "Controller.java";
			String serviceTest = serviceTestPath + "/" + model + "ServiceImplTest.java";
            VelocityContext context = new VelocityContext();
            context.put("package_name", package_name);
            context.put("model", model);
			context.put("modelLowerFirst", modelLowerFirst);
            context.put("ctime", ctime);
			// 生成service
			File serviceFile = new File(service);
//			if (!serviceFile.exists()) {

				VelocityUtil.generate(serviceVm, service, context);
//			}
			// 生成serviceImpl
			File serviceImplFile = new File(serviceImpl);
//			if (!serviceImplFile.exists()) {

				VelocityUtil.generate(serviceImplVm, serviceImpl, context);
//			}
            // 生成Controller
            File controllerFile = new File(controller);
//            if (!controllerFile.exists()) {
                VelocityUtil.generate(controllerVm, controller, context);
//            }
			// 生成服务单元测试
			File serviceTestFile = new File(serviceTest);
//            if (!controllerFile.exists()) {
			VelocityUtil.generate(serviceTestVm, serviceTest, context);
//            }
		}
		logger.info("========== 结束生成 Service ServiceImpl Controller ServiceTest==========");

	}

	// 递归删除非空文件夹
	public static void deleteDir(File dir) {
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteDir(files[i]);
			}
		}
		dir.delete();
	}

}
