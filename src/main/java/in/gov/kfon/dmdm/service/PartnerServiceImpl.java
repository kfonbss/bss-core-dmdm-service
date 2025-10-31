package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
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
  private final ModelMapper modelMapper;

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
}
