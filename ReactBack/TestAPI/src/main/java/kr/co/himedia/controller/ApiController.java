package kr.co.himedia.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// RestAPI 테스트 도구
// PostMan / VS-code - Thunder Client(plug in) / Webstorm - Http Client


@CrossOrigin
@RestController
public class ApiController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	Map<String, Object> result = null;
	
	@GetMapping(value="/")
	public Map<String, Object> home(){
		result = new HashMap<String, Object>();
		result.put("msg", "welcome to Api Server");
		return result;
	}
	
	// GET http://localhost/overlay/admin
	// Accept: application/json
	@GetMapping(value="/overlay/{id}")
	public Map<String, Object> overlay(@PathVariable String id){
		logger.info("중복체크 : "+id);
		result = new HashMap<String, Object>();
		result.put("use", true);
		return result;
	}
	
	
	/*
	    POST http://localhost/overlay
		content-type: application/json

		{"id": "test_id"}	 
	 */
	@PostMapping(value = "/overlay")
	public Map<String, Object> overlay(@RequestBody Map<String, String> params){
		logger.info("중복체크(POST) : "+params);
		result = new HashMap<String, Object>();
		result.put("use", true);
		return result;
	}
	
	
	/*
	 	POST http://localhost/upload
		Content-Type: multipart/form-data; boundary=boundary
		
		--boundary
		Content-Disposition: form-data; name="file"; filename="chrome.png";
		Content-type: image/png
		
		< C:/img/chrome.png
		--boundary 
	 */
	@PostMapping(value="/upload")
	public Map<String, Object>upload(MultipartFile file){
		
		String ori_filename = file.getOriginalFilename();
		String ext = ori_filename.substring(ori_filename.lastIndexOf("."));
		String new_filename = UUID.randomUUID().toString()+ext;
		result = new HashMap<String, Object>();
		
		try {
			byte[] arr = file.getBytes();
			Path path = Paths.get("C:/upload/"+new_filename);
			Files.write(path, arr);
			result.put("path", "/files/"+new_filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return result;
	}
	
	
	@RequestMapping(value="/files/{filename}")
	public ResponseEntity<Resource> showImg(@PathVariable String filename) throws IOException{
		
		String path = "C:/upload/"+filename;
		Resource resource = new FileSystemResource(path);
		HttpHeaders header =  new HttpHeaders();
		String type = Files.probeContentType(Paths.get(path));
		header.add("Content-Type", type);
				
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	@PostMapping(value="/api/upload/param.do")
	public Map<String, Object> testApi(List<MultipartFile> upfiles, @RequestParam Map<String, String> params ){
		
		List<String> list = new ArrayList<String>();
		for (MultipartFile file : upfiles) {
			list.add(file.getOriginalFilename());
		}		
		logger.info("param : {}",params);		
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("filename", list);
		result.put("orderNo", params.get("orderNo"));
		result.put("gridData", params.get("gridData"));
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}













