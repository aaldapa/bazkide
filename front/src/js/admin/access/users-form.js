import { renderUserList } from './users-list.js';

export function initUserForm() {
  console.log('[userForm] Inicializado');

  $('#guardarUsuario').on('click', (e) => {
    e.preventDefault();

    // Simulación guardar
    console.log('[userForm] Usuario guardado (simulado)');
    alert('Usuario guardado');

    renderUserList(''); // Recargar lista
  });
}

export function openUserForm(id) {
  console.log('[userForm] Abriendo formulario para ID:', id);

  // Simulación de rellenar formulario
  $('form input[type="text"]').val(`Usuario con ID ${id}`);
}