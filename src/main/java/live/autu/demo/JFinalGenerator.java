package live.autu.demo;

import com.jfinal.kit.PathKit;

import live.autu.generator.GeneratorApplication;
import live.autu.generator.core.MetaBuilder;
import live.autu.generator.generator.jfinal.BaseModelGenerator;
import live.autu.generator.generator.jfinal.ModelGenerator;

public class JFinalGenerator {

	public static void main(String[] args) {
		
		// baseModel 所使用的包名 
		String baseModelPackageName = "live.autu.demo.model.baseModel";
		// baseModel 文件保存路径 
		String baseModelOutputDir = PathKit.getWebRootPath()
				+ "/src/main/java/live/autu/demo/model/baseModel";
		
		// baseModel 所使用的包名 
		String modelPackageName = "live.autu.demo.model";
		// baseModel 文件保存路径 
		String modelOutputDir = PathKit.getWebRootPath()
				+ "/src/main/java/live/autu/demo/model";

		GeneratorApplication application=new GeneratorApplication();
		application.addGenerator(
				new BaseModelGenerator()
				.setPackageName(baseModelPackageName)
				.setGenerateChainSetter(true)
				.setOverride(true)
				.setOutputDir(baseModelOutputDir)
				)
		.addGenerator(
				new ModelGenerator()
				.setPackageName(modelPackageName)
				.setBaseModelPackageName(baseModelPackageName)
				.setOverride(true)
				.setOutputDir(modelOutputDir)
		 );
		application.setMetaBuilder(new MetaBuilder());
		application.generate();
	}
	
}
