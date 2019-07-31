public class vacDestinationLL {

	/**************** ATTRIBUTES *******************************************
	 ***********************************************************************/

	private vacationDestination vacation;	//stores the heads vacationDestination
	private vacDestinationLL next;		//stores the location of the next element in the list
	
	/**************** CONSTRUCTORS *****************************************
	 ***********************************************************************/

	public vacDestinationLL() {
		vacation = null;
		next = null;
	}
	
	public vacDestinationLL(vacationDestination vacation) {
        this.vacation = vacation;
		next = null;
    }	
	
	public vacDestinationLL(vacationDestination vacation, vacDestinationLL next) {
        this.vacation = vacation;
		this.next = next;
    }	
	
	/***************** SETTERS / MUTATORS **********************************
	 ***********************************************************************/

	public void setVacation(vacationDestination vacation) {
		this.vacation = vacation;
	}
	
    public void setNext(vacDestinationLL next) {
		this.next = next;
	}
    
	/**************** GETTERS / ACCESSORS **********************************
	 ***********************************************************************/
	
	public vacationDestination getVacation() {
		return vacation;
	}
	
    public vacDestinationLL getNext() {
		return next;
	}	
    
	/***********************************************************************
	 * Other methods, as specified in lab instructions 
	 ***********************************************************************/
	
	/**
	 * Prints every list item as long as the variable next isn't a null value.
	 * 
	 * @see VacationDestination#print()
	 */
	
	
	public void printLL() { //works
		
		vacDestinationLL temp = this;
		
		while (temp != null) {
			temp.getVacation().print();
			temp = temp.getNext();
		}
		
	}

	/**
	 * Goes throught the list (vacDestinationLL) and counts the number of filled
	 * vacation variables.
	 * 
	 * @return the total number of elements in vacDestinationLL
	 */
	
	public int sizeLL() {	//works
		
		int counter = 0;
		vacDestinationLL temp = this;

		while (temp != null) {
			temp = temp.getNext();
			++counter;
		}

		return counter;
    }
	
	/**
	 * Uses recursion to find the length of the linked list (vacDestinationLL)
	 * 
	 * @return the total number of elements in vacDestinationLL
	 * @see this.recTemp
	 * @see vacDestinationLL#sizeLL()
	 */
	
	public int sizeLLR() {	//works
		
		if (next != null) {
			return 1 + next.sizeLLR();
		}
		else if (this != null) {
			return 1;
		}
		else {
			return 0;
		}
    }
	
    /*
	 * Removes the head element from the linked list and replaces it by assigning the current head
	 * values to the next item in the list (this.next)
	 */
	
	public void removeHead() {	
		
		if (this == null) {
			throw new NullPointerException("vacDestinationLL#removeHead(): unexpected null value");		//EXCEPTION
		}
		else {
			vacDestinationLL temp = next;
			this.vacation = temp.getVacation();
			this.next = temp.getNext();
		}
	}

	/*
	 * Adds the argument vacation as an elemnt at the end of the linked list.
	 */
	
	public void addTail(vacationDestination vacation) {		//works

		if (this.vacation == null) {
			this.setVacation(vacation);
		}
		
		else {
			vacDestinationLL temp = this;
			
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			
			temp.setNext(new vacDestinationLL(vacation));
		}
    }
	
	/*
	 * Adds the argument vacation after the n-th item in the linked list.
	 */
	
	public void addNth(vacationDestination vacation, int n) {	// adds VD in a new node of the list and inserts it at between nodes n and n+1 of the current list
        
		if (n > this.sizeLL()) {
			throw new IndexOutOfBoundsException("vacDestinationLL#addNth(): Index out of Bounds");	//EXCEPTION
		}
		
		else if (n == 0) {
			vacDestinationLL temp = new vacDestinationLL(this.getVacation(), this.getNext());
			this.setVacation(vacation);
			this.setNext(temp);
		}
		
		else {
			vacDestinationLL temp = next;
			vacDestinationLL tempPrev = this;
			
			while ((n > 1) && (temp != null)) {
				--n;
				tempPrev = temp;
				temp = temp.getNext();
			}
			
			vacDestinationLL newVacation = new vacDestinationLL(vacation);
			
			tempPrev.setNext(newVacation);
			newVacation.setNext(temp);
		}
		
	}

}
