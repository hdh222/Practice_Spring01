package com.practice.spring01.users.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.practice.spring01.users.dao.UsersDao;
import com.practice.spring01.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersDao usersDao;

	@Override
	public void addUser(UsersDto dto) {
		// TODO Auto-generated method stub
		String inputPwd = dto.getPwd();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String encodedPwd = encoder.encode(inputPwd);
		
		dto.setPwd(encodedPwd);
		
		usersDao.insert(dto);
	}

	@Override
	public Map<String, Object> checkId(String inputId) {
		// TODO Auto-generated method stub
		
		boolean isExist = usersDao.checkId(inputId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("isExist", isExist);
		
		return map;
	}

	@Override
	public void loginProcess(UsersDto dto, ModelAndView mView, HttpSession session) {
		// TODO Auto-generated method stub
		
		boolean isValid = false;
		
		UsersDto resultDto = usersDao.getData(dto.getId());
		
		if(resultDto != null) {
			String encodedPwd = resultDto.getPwd();
			String inputPwd = dto.getPwd();
			isValid = BCrypt.checkpw(inputPwd, encodedPwd);
		}

		if(isValid) {
			session.setAttribute("id", dto.getId());
			mView.addObject("isSuccess", true);
		}else {
			mView.addObject("isSuccess", false);
		}
	}

	@Override
	public void getData(HttpSession session, ModelAndView mView) {
		// TODO Auto-generated method stub
		String id = (String)session.getAttribute("id");
		
		UsersDto dto = usersDao.getData(id);
		mView.addObject("dto", dto);
	}

	@Override
	public void deleteUser(HttpSession session) {
		// TODO Auto-generated method stub
		String id = (String)session.getAttribute("id");
		usersDao.delete(id);
		session.invalidate();
	}

	@Override
	public Map<String, Object> saveProfileImage(HttpServletRequest request, MultipartFile mFile) {
		// TODO Auto-generated method stub
		
		String orgFileName = mFile.getOriginalFilename();
		
		String realPath = request.getServletContext().getRealPath("/upload");
		
		String filePath = realPath + File.separator;
		
		File upload = new File(filePath);
		
		if(!upload.exists()){
			upload.mkdir();
		}
		
		String saveFileName = System.currentTimeMillis()+orgFileName;
		
		try {
			mFile.transferTo(new File(filePath+saveFileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("imageSrc",  "/upload/"+saveFileName);
		
		
		return map;
	}

	@Override
	public void updateUserInfo(HttpSession session, UsersDto dto) {
		// TODO Auto-generated method stub
		String id = (String)session.getAttribute("id");
		
		dto.setId(id);
		
		usersDao.update(dto);
	}
	

}
