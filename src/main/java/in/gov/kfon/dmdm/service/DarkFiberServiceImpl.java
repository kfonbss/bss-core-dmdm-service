package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.*;
import in.gov.kfon.dmdm.repository.*;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DarkFiberServiceImpl implements DarkFiberService {

  private final DfGroupDetailsRepository dfGroupDetailsRepository;
  private final DfGroupDetailsMoventRepository dfGroupDetailsMoventRepository;
  private final DfGroupInvoiceRepository dfGroupInvoiceRepository;
  private final DfGroupInvoiceMasterRepository dfGroupInvoiceMasterRepository;
  private final DfLinkDetailsRepository dfLinkDetailsRepository;
  private final DfLinkRenewalHistoryRepository dfLinkRenewalHistoryRepository;
  private final DfPowerRatingRepository dfPowerRatingRepository;
  private final DfPurchaseOrderRepository dfPurchaseOrderRepository;
  private final DfRenewalDetailsRepository dfRenewalDetailsRepository;
  private final DfSubFinanceRepository dfSubFinanceRepository;
  private final DfSubscribersRepository subscribersRepository;
  private final DfTransRenewalDetailsRepository transRenewalRepository;
  private final DfTransDetailsRepository dfTransDetailsRepository;
  private final DfTransDetailsMovementRepository dfTransDetailsMovementRepository;
  private final DfWorkorderRepository dfWorkorderRepository;
  private final DfBankDetailsRepository dfBankDetailsRepository;
  private final DfCustomerDetailsRepository dfCustomerDetailsRepository;
  private final DfDemandNoteHistoryRepository dfDemandnoteHistoryRepository;
  private final DfDemandNoteMasterRepository dfDemandNoteMasterRepository;
  private final DfDisbursementRepository dfDisbursementRepository;
  private final DfFeederListRepository dfFeederListRepository;
  private final DfMasterDataRepository dfMasterDataRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllGroupDetails() {
    return dfGroupDetailsRepository.findAll().stream()
        .map(entity -> modelMapper.map(entity, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchGroupDetailsById(UUID id) {
    DfGroupDetails details =
        dfGroupDetailsRepository
            .findByDetailsId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Group Details not found with id: " + id));
    return modelMapper.map(details, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllGroupMovements() {
    return dfGroupDetailsMoventRepository.findAll().stream()
        .map(entity -> modelMapper.map(entity, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchGroupMovementById(UUID id) {
    DfGroupDetailsMovent movent =
        dfGroupDetailsMoventRepository
            .findByMoventId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Group Movement not found with id: " + id));
    return modelMapper.map(movent, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllGroupInvoices() {
    return dfGroupInvoiceRepository.findAll().stream()
        .map(dfGroupInvoice -> modelMapper.map(dfGroupInvoice, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchGroupInvoiceById(UUID id) {
    DfGroupInvoice invoice =
        dfGroupInvoiceRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Group Invoice not found with id: " + id));
    return modelMapper.map(invoice, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllGroupInvoiceMasters() {
    return dfGroupInvoiceMasterRepository.findAll().stream()
        .map(dfGroupInvoiceMaster -> modelMapper.map(dfGroupInvoiceMaster, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchGroupInvoiceMasterById(UUID id) {
    DfGroupInvoiceMaster master =
        dfGroupInvoiceMasterRepository
            .findByMasterId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Group Invoice Master not found with id: " + id));
    return modelMapper.map(master, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllLinkDetails() {
    return dfLinkDetailsRepository.findAll().stream()
        .map(link -> modelMapper.map(link, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchLinkDetailsById(UUID id) {
    DfLinkDetails linkDetails =
        dfLinkDetailsRepository
            .findByDetailsId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Link Details not found with id: " + id));
    return modelMapper.map(linkDetails, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllLinkRenewalHistories() {
    return dfLinkRenewalHistoryRepository.findAll().stream()
        .map(history -> modelMapper.map(history, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchLinkRenewalHistoryById(UUID id) {
    DfLinkRenewalHistory history =
        dfLinkRenewalHistoryRepository
            .findByHistoryId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Link Renewal History not found with id: " + id));
    return modelMapper.map(history, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllPowerRatings() {
    return dfPowerRatingRepository.findAll().stream()
        .map(dfPowerRating -> modelMapper.map(dfPowerRating, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchPowerRatingById(UUID id) {
    DfPowerRating rating =
        dfPowerRatingRepository
            .findByDfPowerRatingId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Power Rating not found with id: " + id));
    return modelMapper.map(rating, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllPurchaseOrders() {
    return dfPurchaseOrderRepository.findAll().stream()
        .map(dfPurchaseOrder -> modelMapper.map(dfPurchaseOrder, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchPurchaseOrderById(UUID id) {
    DfPurchaseOrder order =
        dfPurchaseOrderRepository
            .findByDfPurchaseOrderId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Purchase Order not found with id: " + id));
    return modelMapper.map(order, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllRenewalDetails() {
    return dfRenewalDetailsRepository.findAll().stream()
        .map(renewal -> modelMapper.map(renewal, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchRenewalDetailsById(UUID id) {
    DfRenewalDetails renewal =
        dfRenewalDetailsRepository
            .findByDfRenewalDetailsId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Renewal Detail not found with id: " + id));
    return modelMapper.map(renewal, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllSubFinance() {
    return dfSubFinanceRepository.findAll().stream()
        .map(subFinance -> modelMapper.map(subFinance, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchSubFinanceById(UUID id) {
    DfSubFinance subFinance =
        dfSubFinanceRepository
            .findByDfSubFinanceId(id)
            .orElseThrow(() -> new EntityNotFoundException("SubFinance not found with id: " + id));
    return modelMapper.map(subFinance, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllSubscribers() {
    return subscribersRepository.findAll().stream()
        .map(subscribers -> modelMapper.map(subscribers, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchSubscriberById(UUID id) {
    DfSubscribers dfSubscribers =
        subscribersRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Subscriber not found with id: " + id));
    return modelMapper.map(dfSubscribers, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllTransRenewalDetails() {
    return transRenewalRepository.findAll().stream()
        .map(transRenewalDetails -> modelMapper.map(transRenewalDetails, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchTransRenewalDetailById(UUID id) {
    DfTransRenewalDetails renewalDetails =
        transRenewalRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Trans Renewal Detail not found with id: " + id));
    return modelMapper.map(renewalDetails, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllTransDetails() {
    return dfTransDetailsRepository.findAll().stream()
        .map(transDetails -> modelMapper.map(transDetails, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchTransDetailsById(UUID id) {
    DfTransDetails transDetails =
        dfTransDetailsRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Trans Detail not found with id: " + id));
    return modelMapper.map(transDetails, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllTransDetailsMovements() {
    return dfTransDetailsMovementRepository.findAll().stream()
        .map(movement -> modelMapper.map(movement, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchTransDetailsMovementById(UUID id) {
    DfTransDetailsMovement movement =
        dfTransDetailsMovementRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Trans Movement not found with id: " + id));
    return modelMapper.map(movement, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllWorkorders() {
    return dfWorkorderRepository.findAll().stream()
        .map(w -> modelMapper.map(w, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchWorkorderById(UUID id) {
    DfWorkorder wo =
        dfWorkorderRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Workorder not found with id: " + id));
    return modelMapper.map(wo, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllBankDetails() {
    return dfBankDetailsRepository.findAll().stream()
        .map(b -> modelMapper.map(b, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchBankDetailById(UUID id) {
    DfBankDetails bd =
        dfBankDetailsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Bank Detail not found with id: " + id));
    return modelMapper.map(bd, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllCustomerDetails() {
    return dfCustomerDetailsRepository.findAll().stream()
        .map(customer -> modelMapper.map(customer, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchCustomerDetailsById(UUID id) {
    DfCustomerDetails customer =
        dfCustomerDetailsRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Customer Detail not found with id: " + id));
    return modelMapper.map(customer, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllDemandNoteHistory() {
    return dfDemandnoteHistoryRepository.findAll().stream()
        .map(history -> modelMapper.map(history, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchDemandNoteHistoryById(UUID id) {
    DfDemandNoteHistory history =
        dfDemandnoteHistoryRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Demand Note not found with id: " + id));
    return modelMapper.map(history, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllDemandNotes() {
    return dfDemandNoteMasterRepository.findAll().stream()
        .map(dfDemandNoteMaster -> modelMapper.map(dfDemandNoteMaster, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchDemandNoteById(UUID id) {
    DfDemandNoteMaster demandNote =
        dfDemandNoteMasterRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Demand Note Master not found with id: " + id));
    return modelMapper.map(demandNote, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllDisbursements() {
    return dfDisbursementRepository.findAll().stream()
        .map(disbursement -> modelMapper.map(disbursement, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchDisbursementById(UUID id) {
    DfDisbursement disbursement =
        dfDisbursementRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Disbursement not found with id: " + id));
    return modelMapper.map(disbursement, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllFeeders() {
    return dfFeederListRepository.findAll().stream()
        .map(feederList -> modelMapper.map(feederList, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchFeederById(UUID id) {
    DfFeederList feeder =
        dfFeederListRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Feeder list not found with id: " + id));
    return modelMapper.map(feeder, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllMasterData() {
    return dfMasterDataRepository.findAll().stream()
        .map(entity -> modelMapper.map(entity, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchMasterDataById(UUID id) {
    DfMasterData masterData =
        dfMasterDataRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Master Data not found with id: " + id));
    return modelMapper.map(masterData, CommonLookUp.class);
  }
}
