/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.responsi.service;

/**
 *
 * @author farhannivta
 */
public class TrueDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(double totalAmount) {
        return totalAmount * (12/100);//menghitung total diskon yang didapat
    }

    @Override
    public String getDiscountName() {
        return "Diskon 12 12";
    }
    
}
