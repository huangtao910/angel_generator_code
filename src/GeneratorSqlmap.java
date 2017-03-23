import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.plugins.comment.DynamicCompilerUtil;

import javax.print.DocFlavor;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class GeneratorSqlmap {

	public static void generator(File configFile){
		try{
			//String path = GeneratorSqlmap.class.getClassLoader().getResource("//").getPath();
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;

			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback, warnings);
			myBatisGenerator.generate(null);

		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void createClass(File configFile)throws Exception{
		//获取dao、service、mapper等包名，以及其他信息
		String daoPackage = "";
		String servicePackage = "";
		String logicPackage = "";
		String entityPackage = "";
		String style = "";
		Properties ps = new Properties();
		String configPath = "config.properties";
		//String path = GeneratorSqlmap.class.getClassLoader().getResource("//").getPath();
		String realPath = "./src/";
		ps.load(new BufferedReader(new FileReader(configPath)));
		style = ps.get("style").toString();
		SAXReader reader = new SAXReader();
		reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		Document doc = reader.read(configFile);
		Element root = doc.getRootElement();
		Element context = root.element("context");
		daoPackage = context.element("javaClientGenerator").attribute("targetPackage").getText();
		entityPackage = context.element("javaModelGenerator").attribute("targetPackage").getText();
		servicePackage = daoPackage.replace("dao","service");
		logicPackage = daoPackage.replace("dao","logic");
		List nodes = context.elements("table");
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			Element elm = (Element) it.next();
			Attribute attribute=elm.attribute("domainObjectName");
			String entityName = attribute.getText();
			String filename = entityPackage.replaceAll("\\.", "/");
			String absolutePath = new File("").getAbsolutePath().replaceAll("\\\\","/") + "/src/";
			DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
			String filePath = absolutePath + filename;
			String sourceDir = absolutePath + filename;
			String targetDir = absolutePath;
			//动态编译生成实例
			boolean compilerResult = DynamicCompilerUtil.compiler(filePath, sourceDir, targetDir, diagnostics);
			//生成service
			genereateInterface("Service", style, realPath, servicePackage, entityPackage, entityName);
			//生成serviceimpl
			genereateImpl("Service", style, realPath, servicePackage, daoPackage, entityPackage, entityName);
			//生成logic
			genereateInterface("Logic", style, realPath, logicPackage, entityPackage, entityName);
			//生成logicimpl
			genereateImpl("Logic", style, realPath, logicPackage, daoPackage, entityPackage, entityName);
		}
	}
	public static void main(String[] args) throws Exception {
		try {
			File configFile = new File("generatorConfig.xml");
			GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			generator(configFile);
			//生成service，logic
			createClass(configFile);
			System.out.println("=====================================create success!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

 	}

	private static void genereateInterface(String type ,String style,String configPath,String packageType,String dtoPackage,String dtoName) throws IOException {
		String serviceContent = "";
		if("0".equals(style)){
			serviceContent =
					"package "+packageType+";\r\n\r\n"+
							"import com.crowdfund.common.exception.SystemException;\r\n"+
							"import com.crowdfund.common.page.Page;\r\n"+
							"import java.math.BigDecimal;\r\n"+
							"import java.util.*;\r\n"+
							"import "+dtoPackage+"."+dtoName+";\r\n\r\n"+

							"public interface " + dtoName + type +" {\r\n"+
							"\t/**\r\n"+
							"\t * 删除接口\r\n"+
							"\t * @param id\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\tint deleteByPrimaryKey(Long id) throws SystemException;\r\n\r\n"+

							"\t/**\r\n"+
							"\t * 添加接口\r\n"+
							"\t * @param record\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\tint insert("+dtoName+" record) throws SystemException;\r\n\r\n"+

							"\t/**\r\n"+
							"\t * 添加接口\r\n"+
							"\t * @param record\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\tint insertSelective("+dtoName+" record)throws SystemException;\r\n\r\n"+

							"\t/**\r\n"+
							"\t * 主键查询接口\r\n"+
							"\t * @param id\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\t"+dtoName+" selectByPrimaryKey(Long id)throws SystemException;\r\n\r\n"+

							"\t/**\r\n"+
							"\t * 修改接口\r\n"+
							"\t * @param record\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\tint updateByPrimaryKeySelective("+dtoName+" record)throws SystemException;\r\n\r\n"+

							"\t/**\r\n"+
							"\t * 主键修改接口\r\n"+
							"\t * @param record\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\tint updateByPrimaryKey("+dtoName+" record)throws SystemException;\r\n\r\n"+

							"\t/**\r\n"+
							"\t * 分页查询接口\r\n"+
							"\t * @param example\r\n"+
							"\t * @param page\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\tMap<String,Object> selectPagedByExample(Page page, "+dtoName+" example)throws SystemException;\r\n\r\n"+

							"}";
		}else{
			serviceContent =
					"package "+packageType+";\r\n\r\n"+
							"public interface " + dtoName + type + " {\r\n\r\n"+
							"}";
		}
		System.out.println("输出："+configPath+packageType.replaceAll("\\.", "/")+"/"+ dtoName + type +".java");
		File serviceFile = new File(configPath + packageType.replaceAll("\\.", "/")+"/"+ dtoName + type + ".java");
		File parentFile = serviceFile.getParentFile();
		parentFile.mkdirs();
		serviceFile.createNewFile();
		PrintWriter bw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceFile),"utf-8")));
		//BufferedWriter bw = new BufferedWriter(new FileWriter(serviceFile));

		bw.write(serviceContent);
		bw.close();
	}

	private static void genereateImpl(String type ,String style,String configPath, String packageType,String daoPackage, String dtoPackage,
											 String dtoName) throws Exception {
		String serviceImplContent = "";
		String autoWiredDao = "";
		String autoContext = "";
		String autoDao = "";
		String confidition = "";
		String autolist = "";
		String importPackage = "";
		String importEXPackage = "";

		if (type.equalsIgnoreCase("service")){
			autoWiredDao = dtoName.toLowerCase().substring(0, 1)+dtoName.substring(1)+"Logic";
			autoContext = "@Service("+"\""+dtoName.toLowerCase().substring(0, 1)+dtoName.substring(1) + type+"\""+ ")";
			autoDao = dtoName + "Logic";
			importPackage = "import "+daoPackage.replace("dao","logic")+"."+autoDao+";\r\n";
			confidition = "\t\t\treturn "+autoWiredDao+".deleteByPrimaryKey(id);\r\n";
			autolist ="\tpublic Map<String,Object> selectPagedByExample(Page page, "+dtoName+" record) throws SystemException {\r\n"+
					"\t\ttry {\r\n"+
					"\t\t\treturn "+autoWiredDao+".selectPagedByExample(page,record);\r\n"+
					"\t\t} catch (Exception e) {\r\n"+
					"\t\t\tthrow new SystemException(e.getMessage());\r\n"+
					"\t\t}\r\n"+
					"\t}\r\n\r\n";
		}
		if (type.equalsIgnoreCase("logic")){
			//加载到内存运行
			String var = DynamicCompilerUtil.java(dtoPackage+"."+dtoName);
			autoWiredDao = dtoName.toLowerCase().substring(0, 1)+dtoName.substring(1)+"Mapper";
			autoContext = "@Component";
			autoDao = dtoName + "Mapper";
			/*confidition = "\t\t\t"+ dtoName+ "Example  example = new "+dtoName+"Example();\r\n"+
					"\t\t\t"+dtoName+"Example.Criteria cc = example.createCriteria().andIdEqualTo(id);\r\n"+
					"\t\t\treturn "+autoWiredDao+".deleteByPrimaryKey(example);\r\n";*/
			confidition = "\t\t\treturn "+autoWiredDao+".deleteByPrimaryKey(id);\r\n";
			importPackage = "import org.springframework.stereotype.Component;\r\n"+
							"import "+daoPackage+"."+autoDao+";\r\n"+
							"import org.apache.commons.lang3.StringUtils;\r\n";
			importEXPackage = "import "+dtoPackage+"."+dtoName+"Example;\r\n";
			autolist ="\tpublic Map<String,Object> selectPagedByExample(Page page, "+dtoName+" record) throws SystemException {\r\n"+
					"\t\ttry {\r\n"+
					"\t\t\tMap<String,Object> map = new HashMap<>();\r\n"+
					"\t\t\t"+ dtoName+ "Example  example = new "+dtoName+"Example();\r\n"+
					"\t\t\t"+dtoName+"Example.Criteria criteria = example.or();\r\n"+
					"\t\t\texample.setOrderByClause(\"CREATE_TIME \"+ Page.ORDER_DIRECTION_DESC);\r\n"+
					"\t\t\tif(record != null){\r\n"+
					var +
					"\t\t\t}\r\n"+
					"\t\t\tif(page != null){\r\n"+
					"\t\t\t\tint count = "+autoWiredDao+".countByExample(example);\r\n"+
					"\t\t\t\tpage.setCount(count);\r\n"+
					"\t\t\t\texample.setPage(page);\r\n"+
					"\t\t\t}\r\n"+
					"\t\t\tmap.put(\"list\", "+autoWiredDao+".selectByExample(example));\r\n"+
					"\t\t\tmap.put(\"page\",page);\r\n"+
					"\t\t\treturn map;\r\n"+
					"\t\t} catch (Exception e) {\r\n"+
					"\t\t\tthrow new SystemException(e.getMessage());\r\n"+
					"\t\t}\r\n"+
					"\t}\r\n\r\n";
		}
		if("0".equals(style)){
			serviceImplContent =
					"package "+packageType+".impl;\r\n\r\n"+
							"import com.crowdfund.common.exception.SystemException;\r\n"+
							"import com.crowdfund.common.page.Page;\r\n"+
							"import org.springframework.beans.factory.annotation.Autowired;\r\n"+
							"import org.springframework.stereotype.Service;\r\n"+
							"import java.math.BigDecimal;\r\n"+
							"import java.util.*;\r\n"+
							"import "+dtoPackage+"."+dtoName+";\r\n"+
							importPackage +
							importEXPackage +
							"import "+packageType+"."+ dtoName + type +";\r\n\r\n"+

							""+autoContext+"\r\n"+
							"public class "+ dtoName + type +"Impl implements "+ dtoName + type +" {\r\n"+
							"\t@Autowired\r\n"+
							"\tprivate "+ autoDao +" "+ autoWiredDao +";\r\n\r\n"+

							"\t/**\r\n"+
							"\t * 删除业务实现类\r\n"+
							"\t * @param id\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\t@Override\r\n"+
							"\tpublic int deleteByPrimaryKey(Long id) throws SystemException{\r\n"+
							"\t\ttry {\r\n"+
							confidition +
							"\t\t} catch (Exception e) {\r\n"+
							"\t\t\tthrow new SystemException(e.getMessage());\r\n"+
							"\t\t}\r\n"+
							"\t}\r\n\r\n"+
							"\t/**\r\n"+
							"\t * 添加接口业务实现\r\n"+
							"\t * @param record\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\t@Override\r\n"+
							"\tpublic int insert("+dtoName+" record) throws SystemException{\r\n"+
							"\t\ttry {\r\n"+
							"\t\t\treturn "+autoWiredDao+".insert(record);\r\n"+
							"\t\t} catch (Exception e) {\r\n"+
							"\t\t\tthrow new SystemException(e.getMessage());\r\n"+
							"\t\t}\r\n"+
							"\t}\r\n\r\n"+
							"\t/**\r\n"+
							"\t * 添加接口业务接口实现\r\n"+
							"\t * @param record\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\t@Override\r\n"+
							"\tpublic int insertSelective("+dtoName+" record) throws SystemException{\r\n"+
							"\t\ttry {\r\n"+
							"\t\t\treturn "+autoWiredDao+".insertSelective(record);\r\n"+
							"\t\t} catch (Exception e) {\r\n"+
							"\t\t\tthrow new SystemException(e.getMessage());\r\n"+
							"\t\t}\r\n"+
							"\t}\r\n\r\n"+
							"\t/**\r\n"+
							"\t * 主键查询接口业务实现\r\n"+
							"\t * @param id\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\t@Override\r\n"+
							"\tpublic "+dtoName+" selectByPrimaryKey(Long id) throws SystemException{\r\n"+
							"\t\ttry {\r\n"+
							"\t\t\treturn "+autoWiredDao+".selectByPrimaryKey(id);\r\n"+
							"\t\t} catch (Exception e) {\r\n"+
							"\t\t\tthrow new SystemException(e.getMessage());\r\n"+
							"\t\t}\r\n"+
							"\t}\r\n\r\n"+
							"\t/**\r\n"+
							"\t * 修改接口业务实现\r\n"+
							"\t * @param record\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\t@Override\r\n"+
							"\tpublic int updateByPrimaryKeySelective("+dtoName+" record) throws SystemException{\r\n"+
							"\t\ttry {\r\n"+
							"\t\t\treturn "+autoWiredDao+".updateByPrimaryKeySelective(record);\r\n"+
							"\t\t} catch (Exception e) {\r\n"+
							"\t\t\tthrow new SystemException(e.getMessage());\r\n"+
							"\t\t}\r\n"+
							"\t}\r\n\r\n"+
							"\t/**\r\n"+
							"\t * 分页查询接口业务实现\r\n"+
							"\t * @param record\r\n"+
							"\t * @param page\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\t@Override\r\n"+
							autolist +
							"\t/**\r\n"+
							"\t * 主键修改接口业务实现\r\n"+
							"\t * @param record\r\n"+
							"\t * @return\r\n"+
							"\t * @throws SystemException\r\n"+
							"\t */\r\n"+
							"\t@Override\r\n"+
							"\tpublic int updateByPrimaryKey("+dtoName+" record) throws SystemException{\r\n"+
							"\t\ttry {\r\n"+
							"\t\t\treturn "+autoWiredDao+".updateByPrimaryKey(record);\r\n"+
							"\t\t} catch (Exception e) {\r\n"+
							"\t\t\tthrow new SystemException(e.getMessage());\r\n"+
							"\t\t}\r\n"+
							"\t}\r\n\r\n"+

							"}";
		}else{
			serviceImplContent =
					"package "+packageType+".impl;\r\n\r\n"+
							"import org.springframework.beans.factory.annotation.Autowired;\r\n"+
							"import org.springframework.stereotype.Service;\r\n"+
							"import "+daoPackage+"."+dtoName+"Dao;\r\n"+
							"import "+dtoPackage+"."+dtoName+";\r\n"+
							"import "+packageType+"." + dtoName + type +";\r\n\r\n"+

							""+autoContext+"\r\n"+
							"public class "+ dtoName + type +"Impl implements "+ dtoName + type +"{\r\n\r\n"+

							"\t@Autowired\r\n"+
							"\tprivate "+dtoName+"Dao "+autoWiredDao+";\r\n\r\n"+

							"}";


		}

		System.out.println( configPath + packageType.replaceAll("\\.", "/") + "/impl/" + dtoName + type+"Impl.java");
		File serviceImplFile = new File( configPath + packageType.replaceAll("\\.", "/") + "/impl/" + dtoName + type + "Impl.java");
		File parentFile = serviceImplFile.getParentFile();
		parentFile.mkdirs();
		serviceImplFile.createNewFile();
		PrintWriter bw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceImplFile),"utf-8")));
		//OutputStreamWriter bw = new OutputStreamWriter(new FileOutputStream(serviceImplFile),"UTF-8");
		//BufferedWriter bw = new BufferedWriter(new FileWriter(serviceImplFile));
		bw.write(serviceImplContent);
		bw.close();

	}
}
