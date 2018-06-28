package com.autoDeploy.service.Impl;


import com.autoDeploy.entity.ManageJob;
import com.autoDeploy.entity.po.PoManageJob;
import com.autoDeploy.mapper.ManageJobMapper;
import com.autoDeploy.service.ManageJobService;
import com.autoDeploy.util.UpLoadUtil;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lee
 * @since 2018-05-21
 */
@Service
public class ManageJobServiceImpl extends ServiceImpl<ManageJobMapper, ManageJob> implements ManageJobService {


	private static final Logger logger = LoggerFactory.getLogger(UpLoadUtil.class);

	@Autowired
	private ManageJobMapper manageJobMapper;
	@Override
	public Page<ManageJob> selectPageList(Page<ManageJob> page, Map<String, Object> map) {
		page.setRecords(manageJobMapper.selectPageList(page, map));
		return page;
	}
	@Override
	public List<PoManageJob> findAll(Map<String, Object> map) {
		return manageJobMapper.findAll(map);
	}

	@Override
	public boolean saveFile(MultipartFile file, String filePath) {
		logger.info("上传到：" +filePath);
		String fileName = file.getOriginalFilename();
		logger.info("上传的文件名为：" + fileName);
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的后缀名为：" + suffixName);
		// 文件上传后的路径
		// 解决中文问题，liunx下中文路径，图片显示问题
		//String fileUUName = UUID.randomUUID().toString();

// 用时间控制文件名
//		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//		Calendar calendar = Calendar.getInstance();
//		String dateName = df.format(calendar.getTime())+file.getOriginalFilename();
//
//		String path = filePath + dateName;

		File dest = new File(filePath+fileName);
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
