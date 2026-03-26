package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.PartnerResponse;
import in.gov.kfon.dmdm.model.PartnerAccount;
import in.gov.kfon.dmdm.model.PartnerAgreementDetail;
import in.gov.kfon.dmdm.model.PartnerDemoUsers;
import in.gov.kfon.dmdm.model.PartnerDetail;
import in.gov.kfon.dmdm.repository.*;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

  private final PartnerRepository partnerRepository;
  private final PartnerFinance2Repository partnerFinance2Repository;
  private final PartnerTaxpayerLogsRepository taxpayerLogsRepository;
  private final PartnerGroupRepository partnerGroupRepository;
  private final PartnerGstDetailRepository partnerGstDetailRepository;
  private final PartnerGstInvoiceRepository partnerGstInvoiceRepository;
  private final PartnerOnlineRechargeRepository partnerOnlineRechargeRepository;
  private final PartnerReceiptRepository partnerReceiptRepository;
  private final PartnerAccountBalanceReportRepository partnerAccountBalanceReportRepository;
  private final PartnerDisbursementRepository partnerDisbursementRepository;
  private final PartnerFinanceRepository partnerFinanceRepository;
  private final PartnerConfirmationFromAgnpRepository partnerConfirmationFromAgnpRepository;
  private final PartnerConfirmationFromAgnpMovementRepository
      partnerConfirmationFromAgnpMovementRepository;
  private final PartnerGstValetRepository partnerGstValetRepository;
  private final PartnerRevenueRepository partnerRevenueRepository;
  private final PartnerAccountRepository partnerAccountRepository;
  private final PartnerDetailRepository partnerDetailRepository;
  private final PartnerDemoUsersRepository partnerDemoUsersRepository;
  private final PartnerAgreementDetailRepository partnerAgreementDetailRepository;
  private final ModelMapper modelMapper;

  @Override
  public List<PartnerResponse> fetchAll() {
    return partnerRepository.findAll().stream()
        .map(partner -> modelMapper.map(partner, PartnerResponse.class))
        .toList();
  }

  @Override
  public PartnerResponse fetchById(UUID id) {
    var entity =
        partnerRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Partner not found: " + id));
    return modelMapper.map(entity, PartnerResponse.class);
  }

  @Override
  public List<CommonLookUp> fetchAllFinanceDetails() {
    return partnerFinance2Repository.findAll().stream()
        .map(partnerFinance2 -> modelMapper.map(partnerFinance2, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchFinanceDetailsById(UUID id) {
    var entity =
        partnerFinance2Repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Finance2 not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllTaxpayerLogs() {
    return taxpayerLogsRepository.findAll().stream()
        .map(t -> modelMapper.map(t, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchTaxpayerLogById(UUID id) {
    var entity =
        taxpayerLogsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("TaxpayerLog not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllPartnerGroups() {
    return partnerGroupRepository.findAll().stream()
        .map(g -> modelMapper.map(g, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchPartnerGroupById(UUID id) {
    var entity =
        partnerGroupRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("PartnerGroup not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllPartnerGstDetails() {
    return partnerGstDetailRepository.findAll().stream()
        .map(g -> modelMapper.map(g, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchPartnerGstDetailById(UUID id) {
    var entity =
        partnerGstDetailRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("PartnerGstDetail not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllGstInvoices() {
    return partnerGstInvoiceRepository.findAll().stream()
        .map(partnerGstInvoice -> modelMapper.map(partnerGstInvoice, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchGstInvoiceById(UUID id) {
    var entity =
        partnerGstInvoiceRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("GST Invoice not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllOnlineRecharges() {
    return partnerOnlineRechargeRepository.findAll().stream()
        .map(onlineRecharge -> modelMapper.map(onlineRecharge, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchOnlineRechargeById(UUID id) {
    var entity =
        partnerOnlineRechargeRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Online Recharge not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllPartnerReceipts() {
    return partnerReceiptRepository.findAll().stream()
        .map(partnerReceipt -> modelMapper.map(partnerReceipt, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchPartnerReceiptById(UUID id) {
    var entity =
        partnerReceiptRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("PartnerReciept not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllPartnerAccountReports() {
    return partnerAccountBalanceReportRepository.findAll().stream()
        .map(
            partnerAccountBalanceReport ->
                modelMapper.map(partnerAccountBalanceReport, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchPartnerAccountReportById(UUID id) {
    var entity =
        partnerAccountBalanceReportRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("PartnerAccountBalanceReport not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllPartnerDisbursements() {
    return partnerDisbursementRepository.findAll().stream()
        .map(d -> modelMapper.map(d, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchPartnerDisbursementById(UUID id) {
    var entity =
        partnerDisbursementRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Partner Disbursement not found"));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllPartnerFinances() {
    return partnerFinanceRepository.findAll().stream()
        .map(f -> modelMapper.map(f, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchPartnerFinanceById(UUID id) {
    var entity =
        partnerFinanceRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Partner Finance not found"));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllPartnerConfirmationsFromAgnp() {
    return partnerConfirmationFromAgnpRepository.findAll().stream()
        .map(
            partnerConfirmationFromAgnp ->
                modelMapper.map(partnerConfirmationFromAgnp, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchPartnerConfirmationFromAgnpById(UUID id) {
    var entity =
        partnerConfirmationFromAgnpRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("PartnerConfirmationFromAgnp not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllPartnerConfirmationMovements() {
    return partnerConfirmationFromAgnpMovementRepository.findAll().stream()
        .map(agnpMovement -> modelMapper.map(agnpMovement, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchPartnerConfirmationMovementById(UUID id) {
    var entity =
        partnerConfirmationFromAgnpMovementRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("PartnerConfirmationMovement not found: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllGstValets() {
    return partnerGstValetRepository.findAll().stream()
        .map(gstValet -> modelMapper.map(gstValet, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchGstValetById(UUID id) {
    var entity =
        partnerGstValetRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("PartnerGstValet not found with id: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllRevenues() {
    return partnerRevenueRepository.findAll().stream()
        .map(revenue -> modelMapper.map(revenue, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchRevenueById(UUID id) {
    var entity =
        partnerRevenueRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("PartnerRevenue not found with id: " + id));
    return modelMapper.map(entity, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllAccounts() {
    return partnerAccountRepository.findAll().stream()
        .map(account -> modelMapper.map(account, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchAccountById(UUID id) {
    PartnerAccount account =
        partnerAccountRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("PartnerAccount not found: " + id));
    return modelMapper.map(account, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllPartnerDetails() {
    return partnerDetailRepository.findAll().stream()
        .map(detail -> modelMapper.map(detail, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchPartnerDetailById(UUID id) {
    PartnerDetail detail =
        partnerDetailRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("PartnerDetail not found: " + id));
    return modelMapper.map(detail, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllDemoUsers() {
    return partnerDemoUsersRepository.findAll().stream()
        .map(
            user -> {
              CommonLookUp lookUp = modelMapper.map(user, CommonLookUp.class);
              lookUp.setId(user.getUserId());
              return lookUp;
            })
        .toList();
  }

  @Override
  public CommonLookUp fetchDemoUserById(UUID userId) {
    PartnerDemoUsers user =
        partnerDemoUsersRepository
            .findByUserId(userId)
            .orElseThrow(() -> new EntityNotFoundException("DemoUser not found: " + userId));
    CommonLookUp lookUp = modelMapper.map(user, CommonLookUp.class);
    lookUp.setId(user.getUserId());

    return lookUp;
  }

  @Override
  public List<CommonLookUp> fetchAllAgreementDetails() {
    return partnerAgreementDetailRepository.findAll().stream()
        .map(agreementDetail -> modelMapper.map(agreementDetail, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchAgreementDetailById(UUID detailsId) {
    PartnerAgreementDetail detail =
        partnerAgreementDetailRepository
            .findByDetailsId(detailsId)
            .orElseThrow(
                () -> new EntityNotFoundException("AgreementDetail not found: " + detailsId));
    return modelMapper.map(detail, CommonLookUp.class);
  }
}
