package com.project.BookMyCinemaProject.service;

import com.project.BookMyCinemaProject.dto.CustomerModel;
import com.project.BookMyCinemaProject.entity.Customer;
import com.project.BookMyCinemaProject.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Customerservice {
    @Autowired
    CustomerRepo customerRepo;


    public String addCustomer(Customer customer){

        List<Customer> customerList = customerRepo.findAll();
        List list =new ArrayList<>() ;

        if(customerList.size()>0){
            customerList.forEach(customer1 -> {
                if(customer1.getEmail().equalsIgnoreCase(customer.getEmail()) &&
                        customer1.getAddress().containsAll(customer.getAddress()) &&
                        customer1.getDob().isEqual(customer.getDob()) &&
                        customer1.getCustomerName().equalsIgnoreCase(customer.getCustomerName())){
                    list.add(1);
                }
            });
        }
        if(list.size()>0)
        return "Customer already Present!!";
        long a = customerRepo.count();
        customerRepo.save(customer);
        long b = customerRepo.count();

        if(b>a)
            return "Customer Added Successfully!!";

        return "Customer Not Added";

    }


    public List<CustomerModel> getAllCustomer(){
        List<Customer> customerList = customerRepo.findAll();
        List<CustomerModel> customerModelList = new ArrayList<>();
        if(customerList.size()>0){
            customerModelList=customerList
                    .stream()
                    .map(customer->{
                        CustomerModel cm = new CustomerModel(customer.getCid(),
                                customer.getEmail(),
                                customer.getCustomerName(),
                                customer.getAddress(),
                                customer.getPhoneNo(),
                                customer.getDob());
                        return cm;
                    }).collect(Collectors.toList());

            return  customerModelList;
        }
        return null;
    }
}
