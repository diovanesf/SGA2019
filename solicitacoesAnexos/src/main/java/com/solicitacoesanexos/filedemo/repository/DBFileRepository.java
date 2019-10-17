package com.solicitacoesanexos.filedemo.repository;

import com.solicitacoesanexos.filedemo.model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}