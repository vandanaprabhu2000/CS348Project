package com.cs348.crud.repositories;
import com.cs348.crud.entities.RSVPReport;
import com.cs348.crud.entities.RSVPSearchForm;

import java.util.List;
public interface RSVPReportRepository {
    List<RSVPReport> generateReport();
    List<RSVPReport> generateReport(RSVPSearchForm rsvpSearchForm);
}
