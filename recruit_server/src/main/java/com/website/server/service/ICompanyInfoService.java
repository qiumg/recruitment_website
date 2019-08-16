package com.website.server.service;

import com.website.server.pojo.CompanyInfo;

import java.util.List;

public interface ICompanyInfoService {
  List<CompanyInfo> queryCompanyAndTicket();
}
