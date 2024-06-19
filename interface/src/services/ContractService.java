package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;

		for (int ii = 1; ii <= months; ii++) {
			LocalDate dueDate = contract.getDate().plusMonths(ii);

			double interest = onlinePaymentService.interest(basicQuota, ii);
			double fee = onlinePaymentService.paymentFee(basicQuota + interest);
			double quota = basicQuota + interest + fee;

			contract.getInstalments().add(new Installment(dueDate, quota));
		}
	}
}
