package com.hms.hms.service;

import com.hms.hms.entity.Patient;
import com.hms.hms.entity.User;
import com.hms.hms.repository.PatientRepository;
import com.hms.hms.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    public PatientService(PatientRepository patientRepository, UserRepository userRepository, UserService userService) {
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }

    public Long createPatient(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found"
                ));

        if (patientRepository.existsByUser_Id(userId)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "User is already a patient"
            );
        }

        Patient patient = new Patient();
        patient.setUser(user);

        Patient savedPatient = patientRepository.save(patient);
        return savedPatient.getId();
    }


}