package MainMethod;
import java.util.Comparator;
import Humans.Employee;

public class EmployeeComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		if (((Employee)o1).getSeniority() > ((Employee)o2).getSeniority())
		return 1;
		else if (((Employee)o1).getSeniority() == ((Employee)o2).getSeniority())
		return 0;
		else
		return -1;
		}
}
