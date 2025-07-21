import { initSearchForm } from './users-find.js';
import { initUserList } from './users-list.js';
import { initUserForm } from './users-form.js';

console.log('[usuario] Módulo usuario cargado');

$(document).ready(() => {
  initSearchForm();
  initUserList();
  initUserForm();
});