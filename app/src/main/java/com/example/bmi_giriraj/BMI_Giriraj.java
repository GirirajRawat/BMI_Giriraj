package com.example.bmi_giriraj;

public class BMI_Giriraj {

    private float height,weight;
    private  float bmi;
    private float meter;

    public BMI_Giriraj(float height, float weight) {
        this.height = height;
        this.weight = weight;
    }

    public float Calculate() {
        meter = (height/100);
        bmi = weight/(meter*meter);
        return bmi;
    }
}


