package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.InvDeviceMake;
import in.gov.kfon.dmdm.model.InvDeviceModel;
import in.gov.kfon.dmdm.repository.InvDeviceMakeRepository;
import in.gov.kfon.dmdm.repository.InvDeviceModelRepository;
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
public class InventoryServiceImpl implements InventoryService {

  private final InvDeviceMakeRepository invDeviceMakeRepository;
  private final InvDeviceModelRepository invDeviceModelRepository;
  private final ModelMapper modelMapper;

  @Override
  public List<CommonLookUp> fetchAllDeviceMakes() {
    return invDeviceMakeRepository.findAll().stream()
        .map(deviceMake -> modelMapper.map(deviceMake, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchDeviceMakeById(UUID id) {
    InvDeviceMake deviceMake =
        invDeviceMakeRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Device Make not found with id: " + id));
    return modelMapper.map(deviceMake, CommonLookUp.class);
  }

  @Override
  public List<CommonLookUp> fetchAllDeviceModels() {
    return invDeviceModelRepository.findAll().stream()
        .map(model -> modelMapper.map(model, CommonLookUp.class))
        .toList();
  }

  @Override
  public CommonLookUp fetchDeviceModelById(UUID id) {
    InvDeviceModel deviceModel =
        invDeviceModelRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Device Model not found with id: " + id));
    return modelMapper.map(deviceModel, CommonLookUp.class);
  }
}
