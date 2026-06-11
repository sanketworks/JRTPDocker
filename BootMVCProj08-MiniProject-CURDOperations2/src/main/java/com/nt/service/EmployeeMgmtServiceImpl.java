//EmployeeMgmtServiceImpl.java
package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.EmployeeEntity;
import com.nt.error.EmployeeNotFoundException;
import com.nt.repository.IEmployeeRepository;
import com.nt.vo.EmployeeVO;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private  IEmployeeRepository  empRepo;

	@Override
	public List<EmployeeVO> showAllEmployees() {
		//use repo
		List<EmployeeEntity> listEntities=empRepo.findAll();
		//convert  listEntities to listVO
		List<EmployeeVO>  listVO=new ArrayList();
		listEntities.forEach(entity->{
			EmployeeVO  vo=new EmployeeVO();
			BeanUtils.copyProperties(entity, vo);
			vo.setGrossSalary(vo.getSalary()+vo.getSalary()*0.5);
			vo.setNetSalary(vo.getGrossSalary()-vo.getGrossSalary()*0.2);
			listVO.add(vo);
		});
		
		return listVO;
	
	}

	@Override
	public String registerEmployee(EmployeeVO empVO) {
		//convert  VO class obj to Entity class object
		EmployeeEntity  empEntity=new EmployeeEntity();
		BeanUtils.copyProperties(empVO, empEntity);
		empEntity.setCreatedBy(System.getProperty("user.name"));
		//use  repo
		int idVal=empRepo.save(empEntity).getEmpno();
		return "Employee is saved with id value::"+idVal;
	}

	@Override
	public EmployeeVO showEmployeeById(int no) {
		//use repo
		EmployeeEntity  empEntity=empRepo.findById(no).orElseThrow(()->new EmployeeNotFoundException("Invalid Id"));
	    //copy entity object to VO object
		EmployeeVO empVO=new EmployeeVO();
		BeanUtils.copyProperties(empEntity, empVO);
		return empVO;
	}
	
	@Override
	public String editEmployee(EmployeeVO empVO) {
		//load the object
		EmployeeEntity  empEntity=empRepo.findById(empVO.getEmpno()).orElseThrow(()->new EmployeeNotFoundException("Invalid Id"));
		//copy  VO object data to Entity object data
		BeanUtils.copyProperties(empVO, empEntity);
		empEntity.setUpdatedBy(System.getProperty("user.name"));
		//update the object
		empRepo.save(empEntity);
		return empVO.getEmpno()+" Employee Data is Updated";
	}
	
	@Override
	public String removeEmployeeById(int id) {
		//load the object
		EmployeeEntity  empEntity=empRepo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Invalid Id"));
	   //use repo
		empRepo.deleteById(id);
		
		return id+" Employee is Deleted";
	}
	
	
	

}
