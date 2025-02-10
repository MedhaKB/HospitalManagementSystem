package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.client.AppointmentClient;
import com.example.demo.dto.AppointmentDto;
import com.example.demo.entity.Medicine;
import com.example.demo.entity.Prescription;
import com.example.demo.exception.AppointmentNotFoundException;
import com.example.demo.exception.PrescriptionNotFound;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.repository.PrescriptionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

	private static final Logger logger = LoggerFactory.getLogger(PrescriptionServiceImpl.class);

	private MedicineRepository medRepo;

	private PrescriptionRepository presRepo;

	private AppointmentClient client;

	@Override
	public Medicine addMedicine(Medicine medicine, int pid) {
		logger.debug("Adding medicine with PID: {}", pid);
		medicine.setPid(pid);
		Medicine savedMedicine = medRepo.save(medicine);
		logger.debug("Saved medicine: {}", savedMedicine);
		return savedMedicine;
	}

	/**
	 * Finds medicines by prescription ID (pid).
	 * 
	 * @param pid the prescription ID
	 * @return list of medicines
	 */
	public List<Medicine> findMedicneById(int pid) {
		return medRepo.findByPid(pid);
	}

	/**
	 * Adds a prescription with medicines based on appointment ID.
	 * 
	 * @param aid          the appointment ID
	 * @param prescription the prescription entity
	 * @return the saved prescription entity wrapped in ResponseEntity
	 */
	public ResponseEntity<Prescription> addPrescription(int aid, Prescription prescription) {
		AppointmentDto app = client.getById(aid).getBody();
		if(app!=null) {
		prescription.setDoctorid(app.getDoctorId());
		prescription.setPatientid(app.getPatientId());
		List<Medicine> medicine = medRepo.findByPid(prescription.getPid());
		prescription.setMedicine(medicine);
		prescription.setDate(LocalDate.now());
		return ResponseEntity.ok(presRepo.save(prescription));
	}
		else {
			throw new AppointmentNotFoundException("Appointment with" +aid+ "is not found");
		}
	}

	/**
	 * Deletes a prescription by ID.
	 * 
	 * @param pid the prescription ID
	 * @return a success message wrapped in ResponseEntity
	 */
	public ResponseEntity<String> deletePrescription(int pid) {
		presRepo.deleteById(pid);
		return ResponseEntity.ok("Deleted Successfully");
	}

	/**
	 * Finds a prescription by patient ID.
	 * 
	 * @param patientId the patient ID
	 * @return the found prescription entity wrapped in ResponseEntity
	 * @throws PrescriptionNotFound if no prescription found for given patient ID
	 */
	public ResponseEntity<Prescription> findByPatientId(int patientId) throws PrescriptionNotFound {
		Optional<Prescription> optional = presRepo.findById(patientId);
		if (optional.isPresent()) {
			Prescription prescription = optional.get();
			return ResponseEntity.ok(prescription);
		} else {
			throw new PrescriptionNotFound("Prescription of id " + patientId);
		}
	}

	/**
	 * Finds a prescription by appointment ID.
	 * 
	 * @param aid the appointment ID
	 * @return the found prescription entity wrapped in ResponseEntity
	 * @throws PrescriptionNotFound if no prescription found for given appointment
	 *                              ID
	 */
	public ResponseEntity<Prescription> findByAid(int aid) throws PrescriptionNotFound {
		Optional<Prescription> optional = presRepo.findById(aid);
		if (optional.isPresent()) {
			Prescription prescription = optional.get();
			return ResponseEntity.ok(prescription);
		} else {
			throw new PrescriptionNotFound("Prescription of id " + aid);
		}
	}
}
