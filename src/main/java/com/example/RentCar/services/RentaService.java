package com.example.RentCar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentCar.dto.Renta.RentaDTO;
import com.example.RentCar.dto.Renta.RentaMapper;
import com.example.RentCar.entities.Renta;
import com.example.RentCar.repositories.CarroRepository;
import com.example.RentCar.repositories.RentaRepository;
import com.example.RentCar.repositories.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RentaService {

    @Autowired
    private RentaRepository prestamoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CarroRepository carroRepository;

    public RentaDTO CreatePrestamo(RentaDTO prestamoDTO) {
        try {
            if (prestamoDTO.getIdRenta() != null) {
                throw new IllegalArgumentException("La identificación es generada por la base de datos");
            }
            Renta prestamo = RentaMapper.INSTANCE.toEntity(prestamoDTO, usuarioRepository,
                    carroRepository);
            if (prestamo == null) {
                throw new IllegalArgumentException("El prestamo no puede ser NULL");
            }
            Renta prestamoSave = prestamoRepository.save(prestamo);
            return RentaMapper.INSTANCE.toDTO(prestamoSave);
        } catch (Exception e) {
            log.error("ERROR creando el prestamo", e);
        }
        return null;
    }

    public RentaDTO getPrestamoById(Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("Id cannot be null");
            }
            Renta prestamo = prestamoRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("Prestamo no existente"));
            return RentaMapper.INSTANCE.toDTO(prestamo);
        } catch (Exception e) {
            log.error("ERROR buscando el prestamo por el ID", e);
        }
        return null;
    }

    public List<RentaDTO> getAllPrestamos() {
        try {
            List<Renta> prestamos = prestamoRepository.findAll();
            return prestamos.stream().map(RentaMapper.INSTANCE::toDTO).toList();
        } catch (Exception e) {
            log.error("ERROR buscando todos los prestamos", e);
        }
        return List.of();
    }
}
