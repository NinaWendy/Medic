package com.dev.honeycomb_mobile.models;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final String DOCTOR_BASE_URL = "https://mydoctorapi.herokuapp.com";
    public static final String DRUG_URL = "https://app.usarx.com/api/v2/drug/info/";

    public static final List<Doctor> dummyDoctors = new ArrayList<Doctor>() {{
        // Initialize the list with Doctor objects

        add(new Doctor("John", "Doe", "https://www.shutterstock.com/image-photo/healthcare-medical-staff-concept-portrait-600nw-2281024823.jpg", 123456789.0, 4.5, "Dr. John Doe has over 10 years of experience in General Medicine. He is known for his compassionate care and thorough approach to patient diagnosis and treatment. Dr. Doe is committed to providing high-quality healthcare services to all his patients.", "General Medicine", 1.0, "Nairobi Hospital", 5.0));
        add(new Doctor("Jane", "Smith", "https://img.freepik.com/free-photo/beautiful-young-female-doctor-looking-camera-office_1301-7807.jpg", 987654321.0, 4.2, "Dr. Jane Smith specializes in Pediatrics and is renowned for her gentle and friendly approach with children. With 8 years of experience, she has a deep understanding of child health and development, making her a favorite among parents and young patients.", "Pediatrics", 2.0, "Aga Khan University Hospital", 8.0));
        add(new Doctor("Alice", "Brown", "https://images.pexels.com/photos/5998474/pexels-photo-5998474.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 112233445.0, 4.8, "Dr. Alice Brown is an expert in Cardiology with a focus on patient-centered care. Her dedication to cardiovascular health and her ability to communicate complex information in an understandable way have earned her high praise from her patients.", "Cardiology", 1.5, "Kenyatta National Hospital", 10.0));
        add(new Doctor("Robert", "Johnson", "https://images.pexels.com/photos/6627931/pexels-photo-6627931.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 223344556.0, 4.6, "Dr. Robert Johnson is known for his groundbreaking research in Neurology. He has 12 years of experience in treating neurological disorders and is highly regarded for his contributions to neuroscience.", "Neurology", 2.0, "Mater Hospital", 12.0));
        add(new Doctor("Emily", "Clark", "https://images.pexels.com/photos/5327585/pexels-photo-5327585.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 334455667.0, 4.3, "Dr. Emily Clark specializes in Dermatology with a focus on cosmetic treatments. She has 7 years of experience and is known for her innovative techniques and personalized approach to skincare, helping patients achieve their aesthetic goals.", "Dermatology", 3.0, "Karen Hospital", 7.0));

//        add(new Doctor("John", "Doe", "https://www.shutterstock.com/image-photo/healthcare-medical-staff-concept-portrait-600nw-2281024823.jpg", 123456789.0, 4.5, "About John Doe", "General Medicine", 1.0, "Hospital A", 5.0));
//        add(new Doctor("Jane", "Smith", "https://img.freepik.com/free-photo/beautiful-young-female-doctor-looking-camera-office_1301-7807.jpg", 987654321.0, 4.2, "About Jane Smith", "Pediatrics", 2.0, "Hospital B", 8.0));
//        add(new Doctor("John", "Doe", "https://www.shutterstock.com/image-photo/healthcare-medical-staff-concept-portrait-600nw-2281024823.jpg", 123456789.0, 4.5, "About John Doe", "General Medicine", 1.0, "Hospital A", 5.0));
//        add(new Doctor("Jane", "Smith", "https://img.freepik.com/free-photo/beautiful-young-female-doctor-looking-camera-office_1301-7807.jpg", 987654321.0, 4.2, "About Jane Smith", "Pediatrics", 2.0, "Hospital B", 8.0));
//        add(new Doctor("Jane", "Smith", "https://img.freepik.com/free-photo/beautiful-young-female-doctor-looking-camera-office_1301-7807.jpg", 987654321.0, 4.2, "About Jane Smith", "Pediatrics", 2.0, "Hospital B", 8.0));
        // Add more doctors as needed
    }};
}
