package com.cg.onlinenursery.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinenursery.controller.PlantersController;
import com.cg.onlinenursery.entity.Planters;
import com.cg.onlinenursery.entity.Plants;
import com.cg.onlinenursery.entity.Seed;
import com.cg.onlinenursery.repository.PlantersRepository;
import com.cg.onlinenursery.repository.SeedRepository;

@Service
public class PlantersServiceImpl implements IPlantersService {

	@Autowired
	private PlantersRepository plantersRepository;
	Logger logger = LoggerFactory.getLogger(PlantersController.class);

	@Autowired
	private SeedRepository seedRepository;
	
	public PlantersServiceImpl() {
		logger.trace("Trace Planters Constructor is created*****88");
		logger.error("Error Constructor is created*****88");
		logger.info(" Info Planters Constructor is created*****88");
		logger.debug("Debug Planters Constructor is created*****88");
		logger.warn("Warn Planters Constructor is created*****88");
	}

	public List<Planters> viewPlanters(String plantersShape) {
		logger.info("Inside viewPlanters method");
		List<Planters> planters = plantersRepository.planterShape(plantersShape);
		return planters;
	}

	public List<Planters> viewAllPlanters() {
		logger.info("Inside viewPlanters method");
		List<Planters> plantersList = plantersRepository.findAll();
		logger.info(""+plantersList.get(0).getPlanterColor());
		return plantersList;
	}

	public Planters viewPlanters(int plantersId) {
		logger.info("Inside viewPlanters method");
		Optional<Planters> optional = plantersRepository.findById(plantersId);
		Planters planters = null;
		if (optional.isPresent()) {
			planters = optional.get();
		}
		return planters;

	}

	public List<Seed> viewSeeds(int plantersId) {
		logger.info("Inside viewPlanters method");
		Planters planters = viewPlanters(plantersId);
		System.out.println(planters + "*****");
		List<Seed> seeds = null;
		if (planters != null) {
			seeds = planters.getSeeds();
		}
		return seeds;
	}

	// @Override
	public List<Plants> viewPlants(int plantersId) {
		logger.info("Inside viewPlanters method");
		Planters planters = viewPlanters(plantersId);
		System.out.println(planters + "*****");
		List<Plants> plants = null;
		logger.info("New Planters" + planters);
		if (planters != null) {
			plants = planters.getPlants();
		}
		return plants;
	}

	@Override

	public Planters addPlanters(Planters planters) {
		logger.info("Inside viewPlanters method");
		Planters plantersexist = viewPlanters(planters.getPlanterId());
		logger.info("New Planters" + planters);
		if (plantersexist == null) {
			planters = plantersRepository.save(planters);
		}
		return planters;
	}

	public Planters updatePlanters(Planters planters) {
		logger.info("Inside viewPlanters method");
		Planters plantersexist = viewPlanters(planters.getPlanterId());
		logger.info("Update Planters" + planters);
		if (plantersexist != null) {
			planters = plantersRepository.save(planters);
		}
		return planters;
	}

	public Planters deletePlanters(int planterId){
		logger.info("Inside viewPlanters method");
		Planters planters = viewPlanters(planterId);
		logger.info("Delete Planters" + planters);
		if (planters != null)
			plantersRepository.deleteById(planterId);
		return planters;
	}

	public List<Planters> viewAllPlanters(double minCost, double maxCost) {
		logger.info("Inside viewPlanters method");
		List<Planters> plantersList = plantersRepository.findAll();
		return plantersList;
	}
}
