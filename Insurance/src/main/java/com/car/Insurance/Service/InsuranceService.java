package com.car.Insurance.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.car.Insurance.model.Admin;
import com.car.Insurance.model.Admin1;
import com.car.Insurance.model.Admin2;

@Service
public class InsuranceService {
	private List<Admin> detail;
	private List<Admin1> detail1;
	private List<Admin2> detail2;

	public InsuranceService() {
		detail = new ArrayList<Admin>();
		detail.add(new Admin(1.97f, 20, 100d, 50d, 1110d));
		detail.add(new Admin( 1.37f, 20, 100d, 50d, 1110d));
		detail.add(new Admin( 1.67f, 20, 100d, 50d, 1110d));
		detail.add(new Admin(1.37f, 20, 100d, 50d, 1110d));
		detail.add(new Admin(1.97f, 20, 100d, 50d, 1110d));
		detail.add(new Admin(1.57f, 20, 100d, 50d, 1110d));
		
		detail1 = new ArrayList<Admin1>();
		detail1.add(new Admin1(2.97f, 22, 100d, 50d, 1110d));
		detail1.add(new Admin1(1.37f, 20, 100d, 50d, 1110d));
		detail1.add(new Admin1(1.67f, 25, 100d, 50d, 1110d));
		detail1.add(new Admin1(1.37f, 25, 100d, 50d, 1110d));
		detail1.add(new Admin1(1.97f, 25, 100d, 50d, 1110d));
		detail1.add(new Admin1( 1.57f, 25, 100d, 50d, 1110d));
		
		
		detail2 = new ArrayList<Admin2>();
		detail2.add(new Admin2(0.97f, 10, 100d, 50d, 1110d));
		detail2.add(new Admin2( 1.37f, 15, 100d, 50d, 1110d));
		detail2.add(new Admin2(1.67f, 15, 100d, 50d, 1110d));
		detail2.add(new Admin2(1.37f, 15, 100d, 50d, 1110d));
		detail2.add(new Admin2(1.97f, 15, 100d, 50d, 1110d));
		detail2.add(new Admin2(1.57f, 15, 100d, 50d, 1110d));
	}

	
	public long getshowroom_price(String name,String fuel) {
		long price=0;
		if(name.equalsIgnoreCase("audi")&&fuel.equalsIgnoreCase("diesel")) {
			price=416000;
		}
		if(name.equalsIgnoreCase("audi")&&fuel.equalsIgnoreCase("gas")) {
			price=438000;
		}
		if(name.equalsIgnoreCase("benz")&&fuel.equalsIgnoreCase("diesel")) {
			price=449000;
		}
		if(name.equalsIgnoreCase("benz")&&fuel.equalsIgnoreCase("gas")) {
			price=368000;
		}
		if(name.equalsIgnoreCase("bmw")&&fuel.equalsIgnoreCase("diesel")) {
			price=372000;
		}
		if(name.equalsIgnoreCase("bmw")&&fuel.equalsIgnoreCase("petrol")) {
			price=232000;
		}
		return price;
	}
	
	public int getmonth(String year) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date parse = sdf.parse(year);
		Calendar c = Calendar.getInstance();
		c.setTime(parse);
		LocalDate userday = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE));
		LocalDate today = LocalDate.now();
		Period diff = Period.between(userday, today);
		int b=diff.getMonths();
		return b;
	}
	
	public int getyear(String year) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date parse = sdf.parse(year);
		Calendar c = Calendar.getInstance();
		c.setTime(parse);
		LocalDate userday = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE));
		LocalDate today = LocalDate.now();
		Period diff = Period.between(userday, today);
		int a=diff.getYears();
		return a;
	}
	
	public long dep1(int month,int nyear) {
		long dep=0;
		if(month<6 && nyear<1) {
			dep=5;
		}
		else if(month>6 && nyear<1) {
			dep=15;
		}
		else if(nyear>=1 && nyear<2) {
			dep=20;
		}
		else if(nyear>=2 && nyear<3) {
			dep=30;
		}
		else if(nyear>=3 && nyear<4) {
			dep=40;
		}
		else if(nyear>=4 && nyear<5) {
			dep=50;
		}
		return dep;
	}
	
	public long dep2(int month,int year) {
		long dep=0;
		if(month<6 && year<1) {
			dep=7;
		}
		else if(month>6 && year<1) {
			dep=17;
		}
		else if(year>=1 && year<2) {
			dep=22;
		}
		else if(year>=2 && year<3) {
			dep=33;
		}
		else if(year>=3 && year<4) {
			dep=44;
		}
		else if(year>=4 && year<5) {
			dep=55;
		}
		return dep;
	}
	
	public long dep3(int month,int year) {
		long dep=0;
		if(month<6 && year<1) {
			dep=3;
		}
		else if(month>6 && year<1) {
			dep=13;
		}
		else if(year>=1 && year<2) {
			dep=18;
		}
		else if(year>=2 && year<3) {
			dep=28;
		}
		else if(year>=3 && year<4) {
			dep=38;
		}
		else if(year>=4 && year<5) {
			dep=48;
		}
		return dep;
	}
	
	public long getIDV1(String name,String fuel,int month,int year) {
		long insured = getshowroom_price(name, fuel); 
		long depreciation = 0;
		long depreciation_percentage=dep1(month,year);
		depreciation = (insured / 100) * depreciation_percentage;
		long IDV=insured-depreciation;
		return IDV;
	}
	
	public long getIDV2(String name,String fuel,int month,int year) {
		long insured = getshowroom_price(name, fuel); 
		long depreciation = 0;
		long depreciation_percentage=dep2(month,year);
		depreciation = (insured / 100) * depreciation_percentage;
		long IDV=insured-depreciation;
		return IDV;
	}
	
	public long getIDV3(String name,String fuel,int month,int year) {
		long insured = getshowroom_price(name, fuel); 
		long depreciation = 0;
		long depreciation_percentage=dep3(month,year);
		depreciation = (insured / 100) * depreciation_percentage;
		long IDV=insured-depreciation;
		return IDV;
	}
	
	
	public Long getPremium1(String name, String fuel, int month,int no_year) {
		long a = 0;

		for (Admin a1 : detail) {
				
				long IDV=getIDV1(name, fuel, month, no_year);
				long damage = (long) ((IDV / 100) * a1.getOwn_damage());
				long claim = (damage / 100) * 20;
				long total_own = damage - claim;
				long net = (long) (total_own + a1.getThird_party_cover() + a1.getCover() + a1.getLegal_liability());
				long service = (net / 100) * 14;
				a = net + service;				
			}
		
		return a;
	}
	
	public Long getPremium2(String name, String fuel, int month,int no_year) {
		long a = 0;

		for (Admin1 a1 : detail1) {
				long IDV=getIDV2(name, fuel, month, no_year);
				long damage = (long) ((IDV / 100) * a1.getOwn_damage());
				long claim = (damage / 100) * 20;
				long total_own = damage - claim;
				long net = (long) (total_own + a1.getThird_party_cover() + a1.getCover() + a1.getLegal_liability());
				long service = (net / 100) * 14;
				a = net + service;
			}
		return a;
	}
	
	public Long getPremium3(String name, String fuel, int month,int no_year) {
		long a = 0;

		for (Admin2 a1 : detail2) {
				long IDV=getIDV3(name, fuel, month, no_year);
				long damage = (long) ((IDV / 100) * a1.getOwn_damage());
				long claim = (damage / 100) * 20;
				long total_own = damage - claim;
				long net = (long) (total_own + a1.getThird_party_cover() + a1.getCover() + a1.getLegal_liability());
				long service = (net / 100) * 14;
				a = net + service;
				
			}
		return a;
	}
}
