package ops.list.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DirectOps {
	public static void main(String[] args) {
		ArrayList<String> planValidations = new ArrayList<>();
		planValidations.add("Validation_1");
		planValidations.add("Validation_2");
		planValidations.add("Validation_3");
		planValidations.add("Validation_5");
		planValidations.add(null);

		ArrayList<String> transactionValidations = new ArrayList<>();
		transactionValidations.add("Validation_1");
		transactionValidations.add("Validation_2");
		transactionValidations.add("Validation_3");
		transactionValidations.add("Validation_4");
		transactionValidations.add(null);
		System.out.println("list1=" + planValidations);
		System.out.println("list2=" + transactionValidations);
		/**
		 * Retains only the elements in this list that are contained in the specified collection. 
		 * In other words, 
		 * removes from this list all of its elements that are not contained 
		 * in the specified collection
		 * */
		/*System.out.println(list2.retainAll(list1));
		System.out.println("list1=" + list1);
		System.out.println("list2=" + list2);*/
		
/*		System.out.println("list1=" + planValidations);
		System.out.println("list2=" + transactionValidations);*/
		List<String> valitaionsOnlyInPlan = planValidations.stream()
															.filter(Objects::nonNull)
															.filter(aPlanValidattion -> transactionValidations
																	.stream().filter(Objects::nonNull)
																	.noneMatch(aTxnValidation -> aTxnValidation.equals(aPlanValidattion)))
															.collect(Collectors.toList());//will collect only if there is no match in transactionValidations
		
		//List<String> valitaionsOnlyInTxn = transactionValidations.stream().filter(Objects::nonNull).filter(aTxnValidation -> planValidations.stream().filter(Objects::nonNull).noneMatch(aPlanValidation -> aPlanValidation.equals(aTxnValidation))).collect(Collectors.toList());
		/*if(null != valitaionsOnlyInPlan) {
			transactionValidations.addAll(valitaionsOnlyInPlan);
		}*/
		System.out.println(transactionValidations);
		
		List<String> valitaionsOnlyInTxn = new ArrayList<>(planValidations);
		valitaionsOnlyInTxn.removeAll(transactionValidations);
		System.out.println("valitaionsOnlyInTxn2="+valitaionsOnlyInTxn);
		if(null != valitaionsOnlyInTxn) {
			transactionValidations.addAll(valitaionsOnlyInTxn);
		}
		System.out.println("transactionValidations="+transactionValidations);
	}
}
