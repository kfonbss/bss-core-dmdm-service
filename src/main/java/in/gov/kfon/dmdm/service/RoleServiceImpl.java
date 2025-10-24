package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.RoleType;
import in.gov.kfon.dmdm.model.Roles;
import in.gov.kfon.dmdm.model.RolesModules;
import in.gov.kfon.dmdm.repository.RoleTypeRepository;
import in.gov.kfon.dmdm.repository.RolesModulesRepository;
import in.gov.kfon.dmdm.repository.RolesRepository;
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
public class RoleServiceImpl implements RoleService {

  private final RoleTypeRepository roleTypeRepository;
  private final RolesRepository rolesRepository;
  private final RolesModulesRepository rolesModulesRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllRoleTypes() {
    return roleTypeRepository.findAll().stream()
        .map(rt -> modelMapper.map(rt, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchRoleTypeById(UUID id) {
    RoleType roleType =
        roleTypeRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("RoleType not found with id: " + id));
    return modelMapper.map(roleType, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllRoles() {
    return rolesRepository.findAll().stream()
        .map(r -> modelMapper.map(r, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchRoleById(UUID id) {
    Roles roles =
        rolesRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
    return modelMapper.map(roles, CommonLookUp.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> fetchAllRolesModules() {
    return rolesModulesRepository.findAll().stream()
        .map(rm -> modelMapper.map(rm, CommonLookUp.class))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp fetchRolesModuleById(UUID id) {
    RolesModules rolesModules =
        rolesModulesRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("RolesModule not found with id: " + id));
    return modelMapper.map(rolesModules, CommonLookUp.class);
  }
}
