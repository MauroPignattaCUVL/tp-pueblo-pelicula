package com.tssi.pueblo_pelicula.service;

import com.tssi.pueblo_pelicula.dto.*;

import java.time.LocalDate;
import java.util.List;

public interface CinemaService {

  /** Gets the name of all cinemas' names.
   *
   * @return the cinemas' names.
   */
  List<CinemaNameAndIdDTO> getCinemasNamesAndIds();

  /** Finds a Cinema given its id.
   *
   * @return the cinema that matches the id.
   */
  CinemaDTO getCinemaById(final Long id);

  /** Schedules a new Screening at a Cinema.
   *
   * @param screeningScheduleDTO It cannot be null.
   */
  void scheduleScreening(ScreeningScheduleDTO screeningScheduleDTO);

  /** Allows screening replanning by erasing all the screenings scheduled for a given date.
   *
   * @param screeningReplanningDTO It cannot be null.
   */
  void replanning(ScreeningReplanningDTO screeningReplanningDTO);

  /** Gets the screenings for a given date in a cinema.
   *
   * @param screeningsForDateDTO the ScreeningForDateDTO. Cannot be null.
   *
   * @return All the screenings for the given date. Never null, might be empty.
   */
  List<ScreeningDTO> getScreeningsForDate(long cinemaId, long theaterId, LocalDate date);
}
