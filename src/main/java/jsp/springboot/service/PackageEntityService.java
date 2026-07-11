package jsp.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import jsp.springboot.entity.PackageEntity;
import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.repo.PackageEntityRepository;

@Service
public class PackageEntityService {

	@Autowired
	private PackageEntityRepository packageEntityRepository;
	
	
	public ResponseStructure<List<PackageEntity>> getAllPackage(){
		
		ResponseStructure<List<PackageEntity>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("fetching all the data");
		res.setData(packageEntityRepository.findAll());
		
		return res;
	}
}
