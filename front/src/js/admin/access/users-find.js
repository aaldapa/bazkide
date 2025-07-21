import { renderUserList } from './users-list.js';

export function initSearchForm() {
  console.log('[searchForm] Inicializado');

  $('#buscarUsuario').on('click', () => {
    const query = $('#filtroNombre').val();
    console.log('[searchForm] Lanzando búsqueda de:', query);

    // Llama a la función de listado directamente
    renderUserList(query);
  });
}