package com.autoDeploy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UpLoadUtil {

	private static final Logger logger = LoggerFactory.getLogger(UpLoadUtil.class);

	public boolean upLoad(MultipartFile file,String filePath) {
		logger.info("上传到：" +filePath);
		String fileName = file.getOriginalFilename();
		logger.info("上传的文件名为：" + fileName);
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的后缀名为：" + suffixName);
		// 文件上传后的路径
		// 解决中文问题，liunx下中文路径，图片显示问题
		// fileName = UUID.randomUUID() + suffixName;
		File dest = new File(filePath);
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			//FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(dest));
			 file.transferTo(dest);
			logger.info("上传成功");
			return true;

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("上传失败");
		return false;
	}
}
