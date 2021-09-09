## Unidirectional : OneToOne, ManyToOne 
## Bi-Directional : OneToOne, OneToMany

## Bi-directional Mapping:
 >> When TWO entities "X" and "Y" are associated in such a way that,
    you can access "Y" from "X" and "X" from "Y"
	
--|-------------------------------------|--------------------------------------
  |Customer                             | Loan
--|-------------------------------------|--------------------------------------
1 | @OneToMany(mappedBy="customer")     |  @ManyToOne	
2 | private List<Loan> loans;	       |  @JoinColumn(name="cust_id")
3 | 				       |  private Customer customer;


* Property name at line#3 in "Loan" class becomes "mappedBy" at line#1 in "Customer" class
* OneToMany cannot exists without @ManyToOne on the other side!

* Benefits:
  
  ```java
   Customer customer = em.find(Customer.class, 10010);
   //Get all loans
   for(Loan loan : customer.getLoans()){
   	// display the loan details....!
   }
   ```

## OneToOne 
Customer --> custid, name, address, pincode, phone, email ...
Two Additional properties : UserId and Password for Login.
Customer-login --> custid, userid, password
Customer-login-history -> custid, login-datetime, location, status, remarks
	
	Both entities share the same primary key

	
--|-------------------------------------|--------------------------------------
  | Customer                             | CustomerLogin
--|-------------------------------------+--------------------------------------
1 | @Id				      |  @Id
2 | private int custId;		      |  private int custId;
3 | @OneToOne(mappedBy="customer")      |  @OneToOne	
4 | private CustomerLogin	      |  private Customer customer
						

