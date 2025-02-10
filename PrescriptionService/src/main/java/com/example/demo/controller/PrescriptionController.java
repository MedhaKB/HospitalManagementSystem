package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Medicine;
import com.example.demo.entity.Prescription;
import com.example.demo.exception.PrescriptionNotFound;
import com.example.demo.service.PrescriptionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("prescription")
public class PrescriptionController {

    private final PrescriptionService service;

    /**
     * Adds medicine to a prescription identified by pid.
     * @param medicine the medicine entity
     * @param pid the prescription ID
     * @return the saved medicine entity
     */
    @PostMapping("/addMedicine/{pid}")
    public Medicine addMedicine(@RequestBody Medicine medicine, @PathVariable int pid) {
        return service.addMedicine(medicine, pid);
    }

    /**
     * Adds a prescription based on appointment ID.
     * @param aid the appointment ID
     * @param prescription the prescription entity
     * @return the saved prescription entity wrapped in ResponseEntity
     */
    @PostMapping("/add/{aid}")
    public ResponseEntity<Prescription> addPrescription(@PathVariable int aid, @RequestBody Prescription prescription) {
        return service.addPrescription(aid, prescription);
    }

    /**
     * Deletes a prescription by ID.
     * @param pid the prescription ID
     * @return a success message wrapped in ResponseEntity
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePrescription(@PathVariable int pid) {
        return service.deletePrescription(pid);
    }

    /**
     * Finds a prescription by patient ID.
     * @param patientId the patient ID
     * @return the found prescription entity wrapped in ResponseEntity
     * @throws PrescriptionNotFound if no prescription found for given patient ID
     */
    @GetMapping("/show/{patientId}")
    public ResponseEntity<Prescription> findByPatientId(@PathVariable int patientId) throws PrescriptionNotFound {
        return service.findByPatientId(patientId);
    }

    /**
     * Finds a prescription by appointment ID.
     * @param aid the appointment ID
     * @return the found prescription entity wrapped in ResponseEntity
     * @throws PrescriptionNotFound if no prescription found for given appointment ID
     */
    @GetMapping("/getByPrescriptionId/{aid}")
    public ResponseEntity<Prescription> findByAid(@PathVariable int aid) throws PrescriptionNotFound {
        return service.findByAid(aid);
    }
}
