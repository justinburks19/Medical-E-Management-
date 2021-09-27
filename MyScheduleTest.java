package edu.cuny.csi.csc330.group_project;

import java.util.ArrayList;

public class MyScheduleTest {

	public static void main(String[] args) {
		
		MySchedule calendar = new MySchedule("Andris");
		Appointment slot1 = new Appointment("12/02/20 09:00:00", 30);
		Appointment slot2 = new Appointment("12/02/20 09:40:00", 30);
		
				
				boolean flag = calendar.createAppointmentSlot(slot1);
		if(flag)
			System.out.println(slot1 + " sucessful slot creation!");
		else
			System.out.println(slot1 + " does not have a slot available.");
		
			boolean flag2 = calendar.createAppointmentSlot(slot2);
		if(flag2)
			System.out.println(slot2 + " sucessful slot creation!");
		else
			System.out.println(slot2 + " does not have a slot available.");
		
		
		flag = calendar.bookAppointment("Andris", "28/02/21 09:40:00", 30, "Dr, Kogos");	
		if(flag)
			System.out.println("Your appointment was booked!");
		else 
			System.out.println("Your appointment cannot be booked, adust your time.");
		
		
		

	
		flag = calendar.cancelAppointment("12/02/20 09:00:00");
		if(flag)
			System.out.println("Your appointment has been cancelled!");
		else
			System.out.println("No appointment found.");
	}
}
//dd/MM/yy HH:mm:ss