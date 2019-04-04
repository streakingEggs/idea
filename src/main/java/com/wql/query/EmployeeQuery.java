package com.wql.query;

import com.wql.model.Employee;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class EmployeeQuery implements Specification<Employee> {

    private String name;

    private int sex=-1;

    private String phone;

    private int depaId;

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate>list =new LinkedList<Predicate>();

        if(name!=null && !name.trim().equals("")){
            list.add(cb.like(root.get("name").as(String.class),"%"+name.trim()+"%"));
        }
        if(phone!=null && !phone.trim().equals("")){
            list.add(cb.equal(root.get("phone").as(String.class),phone.trim()));
        }
        if(sex!=-1){
            list.add(cb.equal(root.get("sex").as(Integer.class),sex));
        }
        if(depaId!=0){
            list.add(cb.equal(root.get("department").get("id").as(Integer.class),depaId));
        }

        if(list.size()>0){
            query.where(list.toArray(new Predicate[list.size()]));
        }

        return query.getRestriction();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDepaId() {
        return depaId;
    }

    public void setDepaId(int depaId) {
        this.depaId = depaId;
    }

    //-----------
    public void setS_name(String name) {
        this.name = name;
    }
    public void setS_sex(int sex) {
        this.sex = sex;
    }
    public void setS_phone(String phone) {
        this.phone = phone;
    }
    public void setS_depaId(int depaid) {
        this.depaId = depaid;
    }
}
