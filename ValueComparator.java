// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109

import java.util.Comparator;
import java.util.Map;

class ValueComparator implements Comparator<query1_data> {
	    Map<query1_data, Integer> base;

	    public ValueComparator(Map<query1_data, Integer> base) {
	        this.base = base;
	    }

	   public int compare(query1_data a, query1_data b) {
	        if (base.get(a) >= base.get(b)) {
	            return -1;
	        } else {
	            return 1;
	        } 
	    }
	}