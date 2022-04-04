package com.parameta.springboot.backend.apirest.integration;

import com.parameta.springboot.backend.apirest.util.Functions;
import com.parametasoap.parametasoap.services.Employee;
import com.parametasoap.parametasoap.services.Insert;
import com.parametasoap.parametasoap.services.InsertResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;


@Component
public class ClientService extends WebServiceGatewaySupport {


    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public com.parameta.springboot.backend.apirest.model.Employee saveEmployee(Object employee) throws Exception {

        Insert request = new Insert();
        request.setEmployee(buildEmployee((com.parameta.springboot.backend.apirest.model.Employee) employee));
        template = new WebServiceTemplate(marshaller);

        JAXBElement<InsertResponse> response = (JAXBElement<InsertResponse>) template.marshalSendAndReceive("http://localhost:8080/parametaSOAP/EmployeeService?wsdl",
                request);

        com.parameta.springboot.backend.apirest.model.Employee empl = buildJson(response.getValue(), (com.parameta.springboot.backend.apirest.model.Employee) employee);

        return empl;

    }

    private Employee buildEmployee(com.parameta.springboot.backend.apirest.model.Employee employee) {
        Employee build = new Employee();

        XMLGregorianCalendar dateEntry = toXMLGregorianCalendar(employee.getDateEntry());
        XMLGregorianCalendar dateBirthday = toXMLGregorianCalendar(employee.getDateEntry());

        build.setName(employee.getName());
        build.setLastName(employee.getLastName());
        build.setSalary(employee.getSalary());
        build.setPosition(employee.getPosition());
        build.setDateEntry(dateEntry);
        build.setDateBirthday(dateBirthday);
        build.setNumberDocument(employee.getNumberDocument());
        build.setTypeDocument(employee.getTypeDocument());
        return build;
    }


    private  XMLGregorianCalendar toXMLGregorianCalendar(String date1) {
        GregorianCalendar gCalendar = new GregorianCalendar();
        Date date = new Date(date1);
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            System.out.println(ex);
        }
        return xmlCalendar;
    }

    private com.parameta.springboot.backend.apirest.model.Employee buildJson(InsertResponse insertResponse, com.parameta.springboot.backend.apirest.model.Employee employee) throws Exception {
        if(insertResponse.getReturn().equals("OK")){
            employee.setAge(Functions.age(employee.getDateBirthday()));
            employee.setTimeEntry(Functions.age(employee.getDateEntry()));
            return employee;
        }

       throw new Exception("Error comunicandose con servicio SOAP");
    }

}
