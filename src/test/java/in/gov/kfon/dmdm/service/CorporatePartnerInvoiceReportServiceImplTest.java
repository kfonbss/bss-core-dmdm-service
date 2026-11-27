package in.gov.kfon.dmdm.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import in.gov.kfon.dmdm.contract.CorporatePartnerInvoiceRegister;
import in.gov.kfon.dmdm.contract.CorporatePartnerInvoiceRegister.Kind;
import in.gov.kfon.dmdm.repository.CorporatePartnerInvoiceReportRepository;
import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@ExtendWith(MockitoExtension.class)
class CorporatePartnerInvoiceReportServiceImplTest {

  private static final LocalDate FROM = LocalDate.of(2026, 10, 1);
  private static final LocalDate TO = LocalDate.of(2026, 10, 31);
  private static final UUID DISTRICT = UUID.fromString("7d1a3c52-0b6e-4f1e-9a51-2f0c6a7e1b11");

  @Mock private CorporatePartnerInvoiceReportRepository repository;

  private CorporatePartnerInvoiceReportServiceImpl service;

  @BeforeEach
  void setUp() {
    service = new CorporatePartnerInvoiceReportServiceImpl(repository);
  }

  @Test
  void agnpReadsAgnpTableWithTrimmedFiltersAndContainsSearch() {
    Page<CorporatePartnerInvoiceRegister.Row> page = Page.empty();
    PageRequest pageable = PageRequest.of(1, 20);
    when(repository.findAgnpRegister(any(), any(), any(), any(), any(), any(), any()))
        .thenReturn(page);

    var out = service.fetchRegister(Kind.AGNP, FROM, TO, DISTRICT, " ca ", 1, " WO-1 ", pageable);

    assertThat(out).isSameAs(page);
    verify(repository).findAgnpRegister(FROM, TO, DISTRICT, "ca", 1, "%WO-1%", pageable);
    verifyNoMoreInteractions(repository);
  }

  @Test
  void lnpReadsLnpTableAndBlankFiltersBecomeNull() {
    PageRequest pageable = PageRequest.of(0, 10);
    when(repository.findLnpRegister(any(), any(), any(), any(), any(), any(), any()))
        .thenReturn(Page.empty());

    service.fetchRegister(Kind.LNP, null, null, null, "", null, "  ", pageable);

    verify(repository).findLnpRegister(null, null, null, null, null, null, pageable);
    verifyNoMoreInteractions(repository);
  }

  @Test
  void totalsRouteByKindWithSameFilters() {
    CorporatePartnerInvoiceRegister.Totals totals =
        mock(CorporatePartnerInvoiceRegister.Totals.class);
    when(repository.findAgnpTotals(any(), any(), any(), any(), any(), any())).thenReturn(totals);
    when(repository.findLnpTotals(any(), any(), any(), any(), any(), any())).thenReturn(totals);

    assertThat(service.fetchTotals(Kind.AGNP, FROM, TO, null, null, 0, "abc")).isSameAs(totals);
    assertThat(service.fetchTotals(Kind.LNP, FROM, TO, DISTRICT, null, null, null))
        .isSameAs(totals);

    verify(repository).findAgnpTotals(FROM, TO, null, null, 0, "%abc%");
    verify(repository).findLnpTotals(FROM, TO, DISTRICT, null, null, null);
  }
}
