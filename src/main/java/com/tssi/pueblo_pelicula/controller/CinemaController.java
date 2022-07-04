package com.tssi.pueblo_pelicula.controller;

import com.tssi.pueblo_pelicula.dto.CinemaDTO;
import com.tssi.pueblo_pelicula.dto.CinemaNameAndIdDTO;
import com.tssi.pueblo_pelicula.dto.ScreeningReplanningDTO;
import com.tssi.pueblo_pelicula.dto.ScreeningScheduleDTO;
import com.tssi.pueblo_pelicula.service.CinemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cinemas")
public class CinemaController {

  private final CinemaService cinemaService;

  @GetMapping("/names")
  @ResponseBody
  @Transactional(readOnly = true)
  public ResponseEntity<List<CinemaNameAndIdDTO>> getAllCinemasKeys() {
    return ResponseEntity.ok(cinemaService.getCinemasNamesAndIds());
  }

  @GetMapping("/{id}")
  @ResponseBody
  @Transactional(readOnly = true)
  public ResponseEntity<CinemaDTO> getById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(cinemaService.getCinemaById(id));
  }

  @PostMapping("/screening/schedule")
  @ResponseBody
  @Transactional
  public ResponseEntity<Void> scheduleScreening(@Valid @RequestBody ScreeningScheduleDTO screeningScheduleDTO) {
    cinemaService.scheduleScreening(screeningScheduleDTO);

    return ResponseEntity.noContent().build();
  }

  @PostMapping("/screening/replanning")
  @ResponseBody
  @Transactional
  public ResponseEntity<Void> replanning(@Valid @RequestBody ScreeningReplanningDTO screeningReplanningDTO) {
    cinemaService.replanning(screeningReplanningDTO);

    return ResponseEntity.noContent().build();
  }
}
