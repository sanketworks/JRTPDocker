package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.entity.TravelPlan;

public interface ITravelPlanMgmtService {
	public String registerTravelPlan(TravelPlan plan); //save operation
	public Map<Integer, String> getTravelPlanCategories(); //for select operation
	public List<TravelPlan> showAllTravelPlans(); //for select operations
	public TravelPlan showTravelPlanById(Integer planId); //for edit operation form launch (To show the existing record for editing)
	public String updateTravelPlan(TravelPlan plan); //for edit operation form submission
	public String deleteTravelPlan(Integer id); //for deletion operation(hard deletion)
	public String changeTravelPlanStatus(Integer planid,String status); //for soft deletion
}
