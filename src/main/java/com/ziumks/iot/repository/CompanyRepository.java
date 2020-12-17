package com.ziumks.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ziumks.iot.domain.CompanyInfo;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyInfo, String> {
	@Query(nativeQuery = true, value = "delete from Companyinfo where co_id = :coId")
	void deleteByCoId(String coId);
	
//	@Modifying
//	@Query("insert Companyinfo(co_id, addr, cjobmn, cjobmn_phone, co_gb, co_nm, co_phone, email, reg_dtm, regrt, use_yn, client_cd, site_cd) values(:coId, :coAddr, :coMngr, :coMngrPhone, :coType, :coNm, :coPhone, :coMngrEmail, sysdate, User Id, true, :clientCd, :siteCd") 
//	public int insert(@Param("coId") String coId, @Param("coAddr") String coAddr, @Param("coMngr") String coMngr, @Param("coMngrPhone") String coMngrPhone, @Param("coType") String coType, @Param("coNm") String coNm, @Param("coMngrEmail") String coMngrEmail, @Param("clientCd") String clientCd, @Param("siteCd") String siteCd);
//	public int insert(@Param("co_id") String coId, @Param("addr") String coAddr, @Param("cjobmn") String coMngr, @Param("cjobmn_phone") String coMngrPhone, @Param("co_gb") String coType, @Param("co_nm") String coNm, @Param("email") String coMngrEmail, @Param("client_cd") String clientCd, @Param("site_cd") String siteCd);

	//	@Query(nativeQuery = true, value = "select * from Companyinfo where id < :id")
//	List<CompanyInfo> findByIdRange(String coId);
}
