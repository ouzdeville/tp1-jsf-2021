/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

@ManagedBean
@SessionScoped
public class DashboardManagedBean implements Serializable{
	private DashboardModel model;

	public DashboardManagedBean(){
		// Initialize the dashboard model
		this.model = new DefaultDashboardModel();
		// Initialize the dashboard column #1
		DashboardColumn column1 = new DefaultDashboardColumn();
		// Initialize the dashboard column #2
		DashboardColumn column2 = new DefaultDashboardColumn();
		// Initialize the dashboard column #3
		DashboardColumn column3 = new DefaultDashboardColumn();
		DashboardColumn column4 = new DefaultDashboardColumn();
		DashboardColumn column5 = new DefaultDashboardColumn();

		// Add widget into column1
		column1.addWidget("fil");
		// Add widget into column2
		column2.addWidget("user");
		// Add widget into column3
		column3.addWidget("ens");		
		column4.addWidget("stat");		
		column5.addWidget("profil");		

		// Add columns into your model
		this.model.addColumn(column1);
		this.model.addColumn(column2);
		this.model.addColumn(column3);
		this.model.addColumn(column4);
		this.model.addColumn(column5);

	}

	public DashboardModel getModel() {
		return model;
	}

	public void setModel(DashboardModel model) {
		this.model = model;
	}
}
