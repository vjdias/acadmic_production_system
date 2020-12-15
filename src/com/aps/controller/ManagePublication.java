package com.aps.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.aps.model.Publication;

public class ManagePublication extends Manage<Publication> {

	protected ArrayList<Publication> get_obj_list(Boolean sort_by) {
		if (sort_by) {
			return (ArrayList<Publication>) obj_list.stream().sorted(Comparator.comparing(Publication::getYear).reversed())
					.collect(Collectors.toList());
		}
		return obj_list;
	}
	
}
